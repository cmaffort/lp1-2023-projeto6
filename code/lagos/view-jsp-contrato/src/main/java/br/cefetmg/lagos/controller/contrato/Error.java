package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Error {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_REDIRECT_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        return "/404.jsp";
    }

    public static String doGet() {
        return "/404.jsp";
    }
}
