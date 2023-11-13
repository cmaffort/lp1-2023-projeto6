package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import jakarta.servlet.http.HttpServletRequest;

public class Login {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        return "/login.jsp";
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doPost(HttpServletRequest request) {
        try {
            UserSessionControl.createSession(request, (new ManterUsuario()).pesquisarPorId(2L));
            return "/home.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}