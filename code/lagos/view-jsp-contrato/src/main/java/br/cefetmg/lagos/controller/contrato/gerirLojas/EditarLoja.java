package br.cefetmg.lagos.controller.contrato.gerirLojas;

import br.cefetmg.lagos.controller.contrato.Error;
import br.cefetmg.lagos.controller.util.ParametersSetters;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.IManterEndereco;
import br.cefetmg.lagos.model.service.ManterEndereco;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.IManterFuncionario;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterFuncionario;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Set;

public class EditarLoja {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));
            Loja loja = manterLoja.pesquisarPorId(lojaId);

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return Error.doGet(request);

            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();
            IManterFuncionario manterFuncionario = new ManterFuncionario();
            UsuarioLoja chefeFiltro = new UsuarioLoja();
            chefeFiltro.setTipo(TipoFuncionario.CHEFE);
            chefeFiltro.setLoja(loja);

            List<Funcionario> funcionariosChefe = manterFuncionario
                    .filtrar(chefeFiltro.getFuncionario(), "tipo_funcionario", "loja__fk");
            List<UsuarioLoja> chefes = manterUsuarioLoja
                    .pesquisarPorQualquerDosRelacionados(funcionariosChefe.toArray(new Funcionario[0]));

            request.setAttribute("loja", loja);
            request.setAttribute("chefes", chefes);
            request.setAttribute("erro", request.getParameter("erro"));

            return new Pair<>("/gerir-lojas/editar-loja.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet();
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
            Loja loja = manterLoja.pesquisarPorId(lojaId);

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return new Pair<>("/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);

            IManterEndereco manterEndereco = new ManterEndereco();
            Endereco endereco = new Endereco();
            endereco.setId(loja.getEndereco().getId());

            ParametersSetters<Endereco> parametersSetter = new ParametersSetters<>(endereco);
            parametersSetter.setParametersFromRequest(request, Set.of("cep", "numero"));

            try {
                manterEndereco.alterar(endereco);
            } catch (NegocioException negocioException) {
                return new Pair<>("/servletweb?acao=EditarLoja&lojaId=" + lojaId + "&erro=" + negocioException.getMessage(),
                        TipoServlet.PAGE_REDIRECT_SERVLET);
            }

            return new Pair<>("/servletweb?acao=ListarLojas", TipoServlet.PAGE_REDIRECT_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>("/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
    }
}
