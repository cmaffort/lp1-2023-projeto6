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

    private static Pair<String, TipoServlet> executeActionLogin(HttpServletRequest request, TipoServlet tipoServlet){
        try {
            String username = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            ManterUsuario manterUsuario = new ManterUsuario();

            Usuario usuario = manterUsuario.pesquisarPorUser(username);
            usuario.setSenha(senha);

                if(manterUsuario.autenticar(usuario)) {
                    UserSessionControl.createSession(request, usuario);

                    return new Pair<>(request.getContextPath() + "/servletweb?acao=Home", tipoServlet);
                }

            return new Pair<>(request.getContextPath() + "/servletweb?acao=Error", tipoServlet);
        } catch (Exception e) {
            return new Pair<>(request.getContextPath() + "/servletweb?acao=Error", tipoServlet);
        }
    }
    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
        return executeActionLogin(request, getTipoDoPost());
    }

    public static  Pair<String, TipoServlet> doGet(HttpServletRequest request){
        return executeActionLogin(request, getTipoDoGet());
    }
}