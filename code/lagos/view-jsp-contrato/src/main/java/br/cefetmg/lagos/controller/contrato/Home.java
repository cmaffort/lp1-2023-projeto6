package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Home {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            Usuario usuario = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(usuario);
            if (redirectJSP != null)
                return redirectJSP;

            if (usuario.getPermicoes().contains(Permissao.GERIR_LOJAS)) {
                IManterContratoAssinado manterContratoAssinado = new ManterContratoAssinado();
                ContratoAssinado contratoAssinado = manterContratoAssinado.pesquisarContratoAssinadoPorContratante(usuario);
                request.setAttribute("contratoAssinado", contratoAssinado);
            }

            request.setAttribute("lojaContextPath", "/loja");

            return new Pair<>("/home.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
        } catch (Exception e) {
            return Login.doGet(request);
        }
    }
}
