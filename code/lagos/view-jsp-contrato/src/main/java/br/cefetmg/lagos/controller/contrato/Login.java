package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Login {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return new Pair<>("/login.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
        try {
            UserSessionControl.createSession(request, (new ManterUsuario()).pesquisarPorId(2L));
            return new Pair<>(request.getContextPath() + "/servletweb?acao=Home", TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>(request.getContextPath() + "/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
    }
}