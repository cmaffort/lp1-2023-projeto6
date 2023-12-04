package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Logout {

    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    private static Pair<String, TipoServlet> executeLogoutAction(HttpServletRequest request, TipoServlet tipoServlet){
        UserSessionControl.invalidateSession(request);
        return new Pair<>(request.getContextPath() + "/login.jsp",tipoServlet);
    }

    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return executeLogoutAction(request, getTipoDoGet());
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request){
        return executeLogoutAction(request, getTipoDoPost());
    }
}
