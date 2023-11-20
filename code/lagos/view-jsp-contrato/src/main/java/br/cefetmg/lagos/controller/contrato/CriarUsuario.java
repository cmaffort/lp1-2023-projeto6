package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.http.HttpServletRequest;

public class CriarUsuario {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        return new Pair<>("/criar-usuario.jsp", TipoServlet.PAGE_FORWARD_SERVLET);
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
        return new Pair<>("/servletweb?acao=Home", TipoServlet.PAGE_REDIRECT_SERVLET);
    }
}
