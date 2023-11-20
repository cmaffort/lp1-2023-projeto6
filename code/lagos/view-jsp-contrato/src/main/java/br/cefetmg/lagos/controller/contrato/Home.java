package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Home {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return new Pair<>("/home.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
    }
}
