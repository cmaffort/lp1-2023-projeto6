package br.cefetmg.lagos.controller.contrato.gerirLojas;

import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.IManterEndereco;
import br.cefetmg.lagos.model.service.ManterEndereco;
import br.cefetmg.lagos.model.service.contrato.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;

public class CadastrarLoja {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterContratoAssinado manterContratoAssinado = new ManterContratoAssinado();
            ContratoAssinado contratoAssinado = manterContratoAssinado.pesquisarContratoAssinadoPorContratante(contratante);

            IManterLoja manterLoja = new ManterLoja();
            long countLojas = manterLoja.countLojas(contratante);

            request.setAttribute("contratoAssinado", contratoAssinado);
            request.setAttribute("numeroDeLojas", countLojas);
            request.setAttribute("erro", request.getParameter("erro"));

            return "/gerir-lojas/cadastrar-loja.jsp";
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

            IManterContratoAssinado manterContratoAssinado = new ManterContratoAssinado();
            ContratoAssinado contratoAssinado = manterContratoAssinado.pesquisarContratoAssinadoPorContratante(contratante);

            IManterLoja manterLoja = new ManterLoja();
            long countLojas = manterLoja.countLojas(contratante);

            if (contratoAssinado.getContrato().getNumeroDeLojas() <= countLojas)
                return "/servletweb?acao=Error";

            IManterEndereco manterEndereco = new ManterEndereco();
            Endereco endereco = new Endereco();

            ParametersSetters<Endereco> parametersSetter = new ParametersSetters<>(endereco);
            parametersSetter.setParametersFromRequest(request, Set.of("cep", "numero"));

            try {
                manterEndereco.cadastrar(endereco);
            } catch (NegocioException negocioException) {
                return "/servletweb?acao=CadastrarLoja&erro=" + negocioException.getMessage();
            }

            Loja loja = new Loja();
            loja.setUsuario(contratante);
            loja.setEndereco(endereco);
            manterLoja.cadastrar(loja);

            return "/servletweb?acao=ListarLojas";
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}
