package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;

public class LoginLoja {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));

            if (!manterLoja.pesquisarPorId(lojaId).getUsuario().getId().equals(contratante.getId()))
                return Login.doGet(request);

            return new Pair<>("/loja/servletweb?acao=Login&lojaId=" + lojaId + "&erro=" + request.getParameter("erro"), TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet(request);
        }
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));

            if (!manterLoja.pesquisarPorId(lojaId).getUsuario().getId().equals(contratante.getId()))
                return Login.doGet(request);

            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();

            UsuarioLoja usuarioLoja = new UsuarioLoja();
            ParametersSetters<UsuarioLoja> parametersSetter = new ParametersSetters<>(usuarioLoja);
            parametersSetter.setParametersFromRequest(request, Set.of("username", "senha"));

            usuarioLoja = manterUsuarioLoja.filtrar(usuarioLoja, "username").get(0);

            try {
                usuarioLoja = manterUsuarioLoja.filtrar(usuarioLoja, "username").get(0);
                if (!manterUsuarioLoja.autenticar(usuarioLoja))
                    return new Pair<>("/loja/servletweb?acao=LoginPost&usuarioLojaId=" + usuarioLoja.getId(),
                            TipoServlet.PAGE_REDIRECT_SERVLET);
            } catch (NegocioException negocioException) {
                return new Pair<>("/servletweb?acao=LoginLoja&erro=" + negocioException.getMessage(),
                        TipoServlet.PAGE_REDIRECT_SERVLET);
            }

            return new Pair<>("/loja/servletweb?acao=LoginPost&usuarioLojaId=" + usuarioLoja.getId(),
                    TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>("/servleteb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
    }
}
