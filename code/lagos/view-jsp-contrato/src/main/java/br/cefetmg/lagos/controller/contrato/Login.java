package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Login {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    private static Pair<String, TipoServlet> executeActionLogin(HttpServletRequest request){
        try {
            String username = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            Usuario usuario = new ManterUsuario().pesquisarPorUserESenha(username, senha);

            if(new ManterUsuario().autenticar(usuario)) {
                UserSessionControl.createSession(request, usuario);

                return new Pair<>(request.getContextPath() + "/ServletWeb?acao=Home", TipoServlet.PAGE_REDIRECT_SERVLET);
            }

            return new Pair<>(request.getContextPath() + "/ServletWeb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>(request.getContextPath() + "/ServletWeb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
    }
    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
        return executeActionLogin(request);
    }

    public static  Pair<String, TipoServlet> doGet(HttpServletRequest request){
        return executeActionLogin(request);
    }
}