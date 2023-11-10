package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.util.DataBaseParser;
import jakarta.servlet.http.HttpServletRequest;

public class GetXMLLoja {
    public static TipoServlet getTipo() {
        return TipoServlet.FileServlet;
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
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));
            Loja loja = manterLoja.pesquisarPorId(lojaId);

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return Error.execute(request);

            String xmldb = DataBaseParser.dbLojaToXML(loja);

            request.setAttribute("file", xmldb);
            return "text/xml";
        } catch (Exception e) {
            e.printStackTrace();
            return "text/xml";
        }
    }
}
