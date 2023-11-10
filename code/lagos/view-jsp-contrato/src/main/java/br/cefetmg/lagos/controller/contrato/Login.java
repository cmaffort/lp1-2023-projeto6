package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import jakarta.servlet.http.HttpServletRequest;

public class Login {
    public static TipoServlet getTipo() {
        return TipoServlet.JSPServlet;
    }

    public static String execute(HttpServletRequest request) {
        if ("GET".equals(request.getMethod()))
            return doGet(request);
        else
            return doPost(request);

    }

    public static String doGet(HttpServletRequest request) {
        return "/login.jsp";
    }

    public static String doPost(HttpServletRequest request) {
        try {
            System.out.println("Creating session");
            UserSessionControl.createSession(request, (new ManterUsuario()).pesquisarPorId(2L));
            return "/home.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.execute(request);
        }
    }
}