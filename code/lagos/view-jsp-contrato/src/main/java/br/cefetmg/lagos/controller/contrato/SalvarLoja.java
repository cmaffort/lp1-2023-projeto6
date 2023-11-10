package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class SalvarLoja {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        // TODO: Logica salvar loja
        return "/login.jsp";
    }
}
