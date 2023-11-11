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
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        return doGet(request);
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

            if (contratoAssinado == null)
                return AssinarContrato.execute(request);

            System.out.println(contratoAssinado);

            return "/listar-lojas.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/404.jsp";
        }
    }
}
