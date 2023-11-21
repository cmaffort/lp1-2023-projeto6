package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.SessionLoja;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.IManterUsuario;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Objects;
import java.util.Set;

public class Login {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            request.setAttribute("erro", request.getParameter("erro"));
            return new Pair<>("/login.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
        } catch (Exception e) {
            return Error.doGet(request);
        }
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
        try {
            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();
            UsuarioLoja usuarioLojaDadosForm = new UsuarioLoja();

            ParametersSetters<UsuarioLoja> parametersSetter = new ParametersSetters<>(usuarioLojaDadosForm);
            parametersSetter.setParametersFromRequest(request, Set.of("username", "senha"));

            try {
                UsuarioLoja usuarioLoja = manterUsuarioLoja.pesquisarPorUsername(usuarioLojaDadosForm.getUsername());
                usuarioLoja.setSenha(usuarioLojaDadosForm.getSenha());
                if (!manterUsuarioLoja.autenticar(usuarioLoja))
                    throw new Exception("Nome de usuário ou senha inválidos.");
                SessionLoja.createSession(request, usuarioLoja);
            } catch (Exception e) {
                return new Pair<>(request.getContextPath() + "/servletweb?acao=Login&erro=" + e.getMessage(),
                        TipoServlet.PAGE_REDIRECT_SERVLET);
            }

            System.out.println(request.getContextPath() + "/servletweb?acao=Home");

            return new Pair<>(request.getContextPath() + "/servletweb?acao=Home", TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            return new Pair<>(request.getContextPath() + "/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
    }
}