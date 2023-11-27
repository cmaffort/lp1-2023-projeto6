package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.IManterConfiguracoesDeInterface;
import br.cefetmg.lagos.model.service.contrato.ManterConfiguracoesDeInterface;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;

public class PersonalizarInterface {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
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

            return new Pair<>("/personalizar-interface.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
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

            IManterConfiguracoesDeInterface manterConfiguracoesDeInterface = new ManterConfiguracoesDeInterface();
            ConfiguracoesDeInterface configuracoesDeInterface = manterConfiguracoesDeInterface.pesquisarPorContratante(contratante);

            ParametersSetters<ConfiguracoesDeInterface> parametersSetter = new ParametersSetters<>(configuracoesDeInterface);
            parametersSetter.setParametersFromRequest(request, Set.of("nome_da_empresa", "logo", "cor_base"));

            try {
                manterConfiguracoesDeInterface.alterar(configuracoesDeInterface);
            } catch (NegocioException negocioException) {
                return new Pair<>("/servletweb?acao=PersonalizarInterface&erro=" + negocioException.getMessage(),
                        TipoServlet.PAGE_REDIRECT_SERVLET);
            }

            return new Pair<>("/servletweb?acao=Home", TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>("/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
    }
}
