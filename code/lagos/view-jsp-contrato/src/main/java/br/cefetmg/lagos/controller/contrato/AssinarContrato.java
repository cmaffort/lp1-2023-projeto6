package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class AssinarContrato {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return new Pair<>("/assinar-contrato.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
    }
}
