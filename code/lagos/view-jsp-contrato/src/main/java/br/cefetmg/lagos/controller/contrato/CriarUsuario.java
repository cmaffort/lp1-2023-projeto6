package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class CriarUsuario {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        if ("GET".equals(request.getMethod()))
            return doGet(request);
        else
            return doPost(request);
    }

    public static String doGet(HttpServletRequest request) {
        return "/criar-usuario.jsp";
    }

    public static String doPost(HttpServletRequest request) {
        return Home.execute(request);
    }
}
