package br.cefetmg.lagos.controller.util;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.service.loja.IManterFuncionario;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterFuncionario;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import br.cefetmg.lagos.util.Serializer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.TreeMap;

public class SessionLoja {
    public static void createSession(HttpServletRequest request, UsuarioLoja usuarioLoja) throws NullPointerException {
        if (usuarioLoja == null || usuarioLoja.getFuncionario() == null)
            throw new NullPointerException("Usuario e seu funcionário devem ser definidos");
        HttpSession session = request.getSession();
        session.setAttribute("usuarioLoja", usuarioLoja);
    }

    public static UsuarioLoja getSession(HttpServletRequest request) throws IOException, PersistenceException, DTOExeption {
        HttpSession session = request.getSession(false);
        if (session == null)
            return null;

        IManterUsuarioLoja manterUsuario = new ManterUsuarioLoja();
        UsuarioLoja usuarioLoja = (UsuarioLoja) session.getAttribute("usuarioLoja");
        UsuarioLoja usuarioLojaCompleto = manterUsuario.pesquisarPorId(usuarioLoja.getId());

        if (!usuarioLojaCompleto.equals(usuarioLoja)) {
            session.invalidate();
            return null;
        }

        return usuarioLojaCompleto;
    }

    public static String getRedirectIfUserNotOk(UsuarioLoja usuarioLoja, Permissao permissao) throws MissingDataExeption {
        if (usuarioLoja == null)
            return "/login.jsp";

        if (!usuarioLoja.getFuncionario().getPermicoes().contains(permissao))
            return "/404.jsp";

        return null;
    }
}
