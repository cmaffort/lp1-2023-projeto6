package br.cefetmg.lagos.controller.contrato.util;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.service.contrato.IManterUsuario;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.util.Serializer;
import br.cefetmg.lagos.controller.contrato.Error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.TreeMap;

public class UserSessionControl {
    public static void createSession(HttpServletRequest request, Usuario usuario) throws IOException, NullPointerException {
        if (usuario == null)
            throw new NullPointerException("Usuario deve ser definido");
        HttpSession session = request.getSession();
        session.setAttribute("usuario", Serializer.serialize(usuario.toMap()));
    }

    public static Usuario getSession(HttpServletRequest request) throws IOException, PersistenceException, DTOExeption {
        HttpSession session = request.getSession(false);
        if (session == null)
            return null;

        IManterUsuario manterUsuario = new ManterUsuario();
        TreeMap<String, Object> userMap = (TreeMap<String, Object>) Serializer.deserialize((byte[]) session.getAttribute("usuario"));
        Usuario usuario = (new Usuario()).getInstance(userMap);
        Usuario usuarioCompleto = manterUsuario.pesquisarPorId(usuario.getId());

        if (!usuarioCompleto.equals(usuario)) {
            session.invalidate();
            return null;
        }

        return usuarioCompleto;
    }

    public static String getRedirectIfUserNotOk(Usuario usuario, Permissao permissao) throws MissingDataExeption {
        if (usuario == null)
            return "/login.jsp";

        if (!usuario.getPermicoes().contains(permissao))
            return "/404.jsp";

        return null;
    }
}
