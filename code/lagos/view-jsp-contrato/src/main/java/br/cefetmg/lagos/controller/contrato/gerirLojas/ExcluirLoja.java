package br.cefetmg.lagos.controller.contrato.gerirLojas;

import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class ExcluirLoja {
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

            Long id = Long.parseLong(request.getParameter("lojaId"));
            List<Long> ids = manterLoja.pesquisarPorContratante(contratante).stream()
                    .map(Loja::getId)
                    .toList();

            if (!ids.contains(id))
                return "/servletweb?acao=Error";

            Loja loja = new Loja();
            loja.setId(id);
            manterLoja.excluir(loja);

            return "/servletweb?acao=ListarLojas";
        } catch (Exception e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}
