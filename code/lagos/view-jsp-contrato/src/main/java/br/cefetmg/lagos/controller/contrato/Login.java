package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public class Login {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        return "/login.jsp";
    }

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doPost(HttpServletRequest request) {
        try {
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            ManterUsuario manterUsuario = new ManterUsuario();

            List<Usuario> usuarioList = manterUsuario.pesquisarTodos();

            for(Usuario usuario: usuarioList)
                if(usuario.getUsername().equals(user))
                    if(manterUsuario.autenticar(usuario)) {
                        UserSessionControl.createSession(request, (new ManterUsuario()).pesquisarPorId(usuario.getId()));
                        return "/home.jsp";
                    }

        } catch (PersistenceException | NegocioException | IOException e) {
            e.printStackTrace();
            return "/servletweb?acao=Error";
        }
    }
}