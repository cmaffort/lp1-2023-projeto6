package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Home {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        return doGet(request);
    }

    public static String doGet(HttpServletRequest request) {
        return "/home.jsp";
    }
}
