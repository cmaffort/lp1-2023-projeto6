package br.cefetmg.lagos.controller.contrato.gerirLojas.chefe;

import br.cefetmg.lagos.controller.contrato.Error;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;

public class CadastrarChefe {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));
            Loja loja = manterLoja.pesquisarPorId(lojaId);

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return Error.doGet(request);

            request.setAttribute("loja", loja);
            request.setAttribute("erro", request.getParameter("erro"));

            return "/gerir-lojas/gerir-chefes/cadastrar-chefe.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_REDIRECT_SERVLET;
    }

    public static String doPost(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));
            Loja loja = manterLoja.pesquisarPorId(lojaId);

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return Error.doGet(request);

            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();
            UsuarioLoja chefe = new UsuarioLoja();
            chefe.setTipo(TipoFuncionario.CHEFE);
            chefe.setLoja(loja);
            chefe.setAtivo(true);

            ParametersSetters<UsuarioLoja> setterChefe = new ParametersSetters<>(chefe);
            ParametersSetters<Funcionario> setterFuncionario = new ParametersSetters<>(chefe.getFuncionario());
            ParametersSetters<Pessoa> setterPessoa = new ParametersSetters<>(chefe.getPessoa());

            setterChefe.setParametersFromRequest(request, Set.of("username", "senha"));
            setterFuncionario.setParametersFromRequest(request, Set.of("salario"));
            setterPessoa.setParametersFromRequest(request, Set.of("nome", "sobrenome", "nascimento", "email", "telefone"));

            try {
                manterUsuarioLoja.cadastrar(chefe);
            } catch (NegocioException negocioException) {
                return "/servletweb?acao=CadastrarChefe&lojaId=" + lojaId + "&erro=" + negocioException.getMessage();
            }

            return "/servletweb?acao=EditarLoja&lojaId=" + lojaId;
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}
