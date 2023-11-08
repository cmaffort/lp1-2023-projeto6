package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class CriarUsuario {
    public static TipoServlet getTipo() {
        return TipoServlet.JSPServlet;
    }

    public static String execute(HttpServletRequest request) {
        return "/criar-usuario.jsp";
    }
}
