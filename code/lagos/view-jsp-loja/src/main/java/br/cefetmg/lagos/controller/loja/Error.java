package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Error {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return new Pair<>("/404.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
    }
}
