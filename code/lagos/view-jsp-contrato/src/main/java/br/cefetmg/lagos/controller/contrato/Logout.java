package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Logout {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/login.jsp";
    }
}
