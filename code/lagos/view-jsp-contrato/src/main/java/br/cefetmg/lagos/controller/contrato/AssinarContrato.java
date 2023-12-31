package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.util.Pair;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class AssinarContrato extends HttpServlet {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.JSON_SERVLET;
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.JSON_SERVLET;
    }

    private static Pair<String, TipoServlet> executeActionAssinarContrato(HttpServletRequest request, TipoServlet tipoServlet){
       return null;
    }

    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return executeActionAssinarContrato(request, getTipoDoGet());
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request){
        return executeActionAssinarContrato(request, getTipoDoPost());
    }
}