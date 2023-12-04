package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.SessionLoja;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.service.contrato.IManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class Home {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            UsuarioLoja usuarioLoja = SessionLoja.getSession(request);
            Pair<String, TipoServlet> redirectJSP = SessionLoja.getRedirectIfUserNotOk(usuarioLoja);
            if (redirectJSP != null)
                return redirectJSP;

            return new Pair<>("/home.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
        } catch (Exception e) {
            return Login.doGet(request);
        }
    }
}
