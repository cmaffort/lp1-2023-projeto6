package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.IManterEndereco;
import br.cefetmg.lagos.model.service.ManterEndereco;
import br.cefetmg.lagos.model.service.contrato.IManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.IManterFuncionario;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterFuncionario;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class EditarLoja {
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

            return "/editar-loja.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet();
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

            IManterEndereco manterEndereco = new ManterEndereco();
            Endereco endereco = new Endereco();
            endereco.setId(loja.getEndereco().getId());

            try {
                endereco.setCep(Integer.parseInt(request.getParameter("cep")));
            } catch (NumberFormatException e) {
                endereco.setCep(null);
            }

            try {
                endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
            } catch (NumberFormatException e) {
                endereco.setNumero(null);
            }

            try {
                manterEndereco.alterar(endereco);
            } catch (NegocioException negocioException) {
                return "/servletweb?acao=EditarLoja&lojaId=" + lojaId + "&erro=" + negocioException.getMessage();
            }

            return "/servletweb?acao=ListarLojas";
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}
