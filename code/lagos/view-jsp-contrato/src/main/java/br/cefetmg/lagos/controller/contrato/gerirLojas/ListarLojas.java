package br.cefetmg.lagos.controller.contrato.gerirLojas;

import br.cefetmg.lagos.controller.contrato.Error;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.*;

import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class ListarLojas {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            List<Loja> lojas = manterLoja.pesquisarPorContratante(contratante);

            IManterContratoAssinado manterContratoAssinado = new ManterContratoAssinado();
            ContratoAssinado contratoAssinado = manterContratoAssinado.pesquisarContratoAssinadoPorContratante(contratante);

            request.setAttribute("lojas", lojas);
            request.setAttribute("contratoAssinado", contratoAssinado);
            request.setAttribute("lojaContextPath", "/loja");

            return new Pair<>("/gerir-lojas/listar-lojas.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet();
        }
    }
}
