package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterConfiguracoesDeInterface;
import br.cefetmg.lagos.model.service.contrato.ManterConfiguracoesDeInterface;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class GetLogoInterface {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            Pair<String, TipoServlet> redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterConfiguracoesDeInterface manterConfiguracoesDeInterface = new ManterConfiguracoesDeInterface();
            ConfiguracoesDeInterface configuracoesDeInterface = manterConfiguracoesDeInterface.pesquisarPorContratante(contratante);

            request.setAttribute("file", configuracoesDeInterface.getLogo());
            return new Pair<>("image/png", TipoServlet.FILE_SERVLET);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>("image/png", TipoServlet.FILE_SERVLET);
        }
    }
}
