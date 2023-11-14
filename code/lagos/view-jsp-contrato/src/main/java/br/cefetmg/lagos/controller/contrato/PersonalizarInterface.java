package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.IManterConfiguracoesDeInterface;
import br.cefetmg.lagos.model.service.contrato.ManterConfiguracoesDeInterface;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;

public class PersonalizarInterface {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterConfiguracoesDeInterface manterConfiguracoesDeInterface = new ManterConfiguracoesDeInterface();
            ConfiguracoesDeInterface configuracoesDeInterface = manterConfiguracoesDeInterface.pesquisarPorContratante(contratante);

            if (configuracoesDeInterface == null) {
                configuracoesDeInterface = new ConfiguracoesDeInterface();
                configuracoesDeInterface.setId(contratante.getId());
                manterConfiguracoesDeInterface.cadastrar(configuracoesDeInterface);
            }

            request.setAttribute("configuracoesDeInterface", configuracoesDeInterface);
            request.setAttribute("erro", request.getParameter("erro"));

            return "/personalizar-interface.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet(request);
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

            IManterConfiguracoesDeInterface manterConfiguracoesDeInterface = new ManterConfiguracoesDeInterface();
            ConfiguracoesDeInterface configuracoesDeInterface = manterConfiguracoesDeInterface.pesquisarPorContratante(contratante);

            ParametersSetters<ConfiguracoesDeInterface> parametersSetter = new ParametersSetters<>(configuracoesDeInterface);
            System.out.println(request.getParameter("cor_base"));
            parametersSetter.setParametersFromRequest(request, Set.of("nome_da_empresa", "logo", "cor_base"));

            try {
                manterConfiguracoesDeInterface.alterar(configuracoesDeInterface);
            } catch (NegocioException negocioException) {
                return "/servletweb?acao=PersonalizarInterface&erro=" + negocioException.getMessage();
            }

            return "/servletweb?acao=Home";
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}
