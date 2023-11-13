package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class CriarUsuario {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        return "/criar-usuario.jsp";
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_REDIRECT_SERVLET;
    }

    public static String doPost(HttpServletRequest request) {
        return "/servletweb?acao=Home";
    }
}
