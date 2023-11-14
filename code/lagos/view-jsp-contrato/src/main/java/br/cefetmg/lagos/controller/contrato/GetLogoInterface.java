package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterConfiguracoesDeInterface;
import br.cefetmg.lagos.model.service.contrato.ManterConfiguracoesDeInterface;
import jakarta.servlet.http.HttpServletRequest;

public class GetLogoInterface {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.FILE_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterConfiguracoesDeInterface manterConfiguracoesDeInterface = new ManterConfiguracoesDeInterface();
            ConfiguracoesDeInterface configuracoesDeInterface = manterConfiguracoesDeInterface.pesquisarPorContratante(contratante);

            request.setAttribute("file", configuracoesDeInterface.getLogo());
            return "image/png";
        } catch (Exception e) {
            e.printStackTrace();
            return "image/png";
        }
    }
}
