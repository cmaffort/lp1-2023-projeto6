package br.cefetmg.lagos.controller.util;

import br.cefetmg.lagos.controller.util.exception.InputException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.Manager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class ParametersSetters<DataTransferObject extends DTO<DataTransferObject>> {
    private DataTransferObject dto;

    public ParametersSetters(DataTransferObject dto) {
        this.dto = dto;
    }

    public DataTransferObject setParametersFromRequest(HttpServletRequest request, Set<String> columns) {
        Manager<DataTransferObject> manager = dto.getManeger();
        manager.getSetters().entrySet().stream()
                .filter(entry -> columns.contains(entry.getKey()))
                .collect(TreeMap<String, Method>::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), TreeMap::putAll)
                .forEach((column, setter) -> {
            Class<?> type = manager.getTypeForColumn(column);

            if (byte[].class != type && (request.getParameter(column) == null || request.getParameter(column).isEmpty()))
                return;

            try {
                try {
                    Method valueOf = type.getDeclaredMethod("valueOf", String.class);
                    setter.invoke(dto, valueOf.invoke(type, request.getParameter(column)));
                } catch (NoSuchMethodException e) {
                    if (type == String.class)
                        setter.invoke(dto, request.getParameter(column));
                    else if (type == byte[].class) {
                        Part part = request.getPart(column);
                        InputStream inputStream = part.getInputStream();
                        setter.invoke(dto, FileInput.readToBytes(inputStream));
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException | IOException | ServletException |
                     InputException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        });

        return dto;
    }

    public DataTransferObject setParametersFromRequest(HttpServletRequest request) {
        return setParametersFromRequest(request, new HashSet<>(dto.getManeger().getColumns()));
    }
}
