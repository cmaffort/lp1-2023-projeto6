package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import jakarta.servlet.http.HttpServletRequest;

public class Error {
    public static TipoServlet getTipo() {
        return TipoServlet.JSPServlet;
    }

    public static String execute(HttpServletRequest request) {
        return "/404.jsp";
    }
}
