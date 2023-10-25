package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.annotations.Column;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DAO<T extends DTO> {
    private static Map<Object, Object> getMethodsOf(Class<? extends DTO> dto) throws ClassNotFoundException {
        try {
            return Arrays.stream(dto.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(Column.class))
//                    .map(Method::getName)
                    .map(method -> Map.entry(method.getAnnotation(Column.class).nome(), method))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//                    .collect(Collectors.joining(", "));
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getMethodsOf(Pessoa.class));
    }
}
