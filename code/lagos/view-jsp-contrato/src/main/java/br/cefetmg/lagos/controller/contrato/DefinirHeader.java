package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
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

    private static Pair<String, TipoServlet> executeActionHeader(HttpServletRequest request) throws PersistenceException{
        Usuario usuario = UserSessionControl.getSession(request);
        Gson gson = new Gson();

        if (usuario.getTipo().toString().equals("Contratante")) {
            String jsonTipoUser = gson.toJson(usuario.getTipo());
            return new Pair<>(jsonTipoUser, TipoServlet.JSON_SERVLET);
        }

        String jsonTipoUser = gson.toJson(usuario.getTipo());
        return new Pair<>(jsonTipoUser, TipoServlet.JSON_SERVLET);
    }
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) throws PersistenceException{
        return executeActionHeader(request);
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) throws PersistenceException{
        return executeActionHeader(request);
    }
}
