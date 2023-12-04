package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class DefinirHeader {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.JSON_SERVLET;
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.JSON_SERVLET;
    }

    private static Pair<String, TipoServlet> executeActionHeader(HttpServletRequest request, TipoServlet tipoServlet) throws PersistenceException {
        Usuario usuario = UserSessionControl.getSession(request);
        Gson gson = new Gson();

        if(usuario.getTipo() != null){
            String jsonTipoUser = gson.toJson(usuario.getTipo());

            return new Pair<>(jsonTipoUser, tipoServlet);
        }
        return new Pair<>(request.getContextPath() + "servletweb?acao=Error", tipoServlet);
    }
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request){
        try {
            return executeActionHeader(request, getTipoDoGet());
        }catch (PersistenceException e){
            return new Pair<>(request.getContextPath() + "servletweb?acao=Error", getTipoDoGet());
        }
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request){
        try {
            return executeActionHeader(request, getTipoDoGet());
        }catch (PersistenceException e){
            return new Pair<>(request.getContextPath() + "servletweb?acao=Error", getTipoDoPost());
        }
    }
}
