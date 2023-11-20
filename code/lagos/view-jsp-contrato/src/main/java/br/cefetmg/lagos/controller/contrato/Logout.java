package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Logout {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        request.getSession().invalidate();
        return new Pair<>("/login.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
    }
}
