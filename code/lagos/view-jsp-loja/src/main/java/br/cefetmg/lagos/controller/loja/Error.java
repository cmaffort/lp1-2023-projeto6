package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Error {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        return "/404.jsp";
    }
}
