package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class PersonalizarInterface {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        return "/personalizar-interface.jsp";
    }
}
