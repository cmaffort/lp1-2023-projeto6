package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Login {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        if ("GET".equals(request.getMethod()))
            return doGet(request);
        return doPost(request);
//        // TODO: Pegar a variavel lojaId para validar o usuario
//
//        String userStr = request.getParameter("usuario");
//        String senhaStr = request.getParameter("senha");
//
//        request.setAttribute("Usuario", userStr);
//        request.setAttribute("Senha", senhaStr);
//        // TODO: Verificar se o usuario existe
//        return "/index.jsp";
    }

    public static String doGet(HttpServletRequest request) {
        return "/index.jsp";
    }

    public static String doPost(HttpServletRequest request) {
        return "";
    }
}