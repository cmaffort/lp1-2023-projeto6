package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class ListarLojas {
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
            List<Loja> lojas = manterLoja.pesquisarPorContratante(contratante);

            IManterContratoAssinado manterContratoAssinado = new ManterContratoAssinado();
            ContratoAssinado contratoAssinado = manterContratoAssinado.pesquisarContratoAssinadoPorContratante(contratante);

            request.setAttribute("lojas", lojas);
            request.setAttribute("contratoAssinado", contratoAssinado);

            return "/listar-lojas.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet();
        }
    }
}
