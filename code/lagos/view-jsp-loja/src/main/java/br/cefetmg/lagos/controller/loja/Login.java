package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.TipoServlet;
import jakarta.servlet.http.HttpServletRequest;

public class Login {
    public static TipoServlet getTipo() {
        return TipoServlet.JSPServlet;
    }

    public static String execute(HttpServletRequest request) {
        String userStr = request.getParameter("usuario");
        String senhaStr = request.getParameter("senha");

        request.setAttribute("Usuario", userStr);
        request.setAttribute("Senha", senhaStr);
        // TODO: Verificar se o usuario existe
        return "/index.jsp";
    }
}