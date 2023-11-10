package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Logout {
    public static TipoServlet getTipo() {
        return TipoServlet.JSPServlet;
    }

    public static String execute(HttpServletRequest request) {
        return doGet(request);
    }

    public static String doGet(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/login.jsp";
    }
}
