package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class AssinarContrato {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        return doGet(request);
    }

    public static String doGet(HttpServletRequest request) {
        return "/assinar-contrato.jsp";
    }
}
