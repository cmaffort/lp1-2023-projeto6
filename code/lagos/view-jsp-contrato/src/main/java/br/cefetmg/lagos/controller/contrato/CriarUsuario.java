package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.util.Pair;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CriarUsuario extends HttpServlet{

    public static TipoServlet getTipoDoPost() {return TipoServlet.JSON_SERVLET;}

    public static TipoServlet getTipoDoGet() {return TipoServlet.JSON_SERVLET;}

    private static Usuario setUsuario(HttpServletRequest request) throws ParseException {
        Usuario usuario = new Usuario();

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String data = (request.getParameter("dataNascimento"));
        String email = request.getParameter("email");
        Long telefone = Long.valueOf(request.getParameter("telefone"));
        TipoUsuario tipoUser = TipoUsuario.valueOf(request.getParameter("tipoUser"));
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date dataNascimento = new java.sql.Date(format.parse(data).getTime());

        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setNascimento(dataNascimento);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setTipo(tipoUser);
        usuario.setUsername(username);
        usuario.setSenha(senha);

        return usuario;
    }

    private static Pair<String, TipoServlet> executeUsuarioAction(HttpServletRequest request) throws PersistenceException, NegocioException, ParseException {
        Usuario usuario = setUsuario(request);

        ManterUsuario manterUsuario = new ManterUsuario();

        manterUsuario.cadastrar(usuario);

        return new Pair<>("Success", TipoServlet.JSON_SERVLET);
    }

    public static Pair<String, TipoServlet> doGet(HttpServletRequest request){
        try{
            return executeUsuarioAction(request);
        }catch (PersistenceException | ParseException | NegocioException e){
            return new Pair<>("Erro BD", TipoServlet.JSON_SERVLET);
        } catch (Exception e) {
            return new Pair<>("Erro java", TipoServlet.JSON_SERVLET);
        }
    }

    public static Pair<String, TipoServlet> doPost(HttpServletRequest request){
        try{
            return executeUsuarioAction(request);
        }catch (PersistenceException | ParseException | NegocioException e){
            return new Pair<>("Erro BD", TipoServlet.JSON_SERVLET);
        } catch (Exception e) {
            return new Pair<>("Erro java", TipoServlet.JSON_SERVLET);
        }
    }
}
