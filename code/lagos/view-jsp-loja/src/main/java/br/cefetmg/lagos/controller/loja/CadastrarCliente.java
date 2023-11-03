package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.exception.DadoException;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import br.cefetmg.lagos.model.service.ManagerCliente;
import br.cefetmg.lagos.model.dto.loja.Cliente;

import java.util.Map;

public class CadastrarCliente {
    public static TipoServlet getTipo() {
        return TipoServlet.JSONServlet;
    }

    public static String execute(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefoneS = request.getParameter("telefone");
        String email = request.getParameter("email");

        long telefone = Long.parseLong(telefoneS);

        HttpSession session = request.getSession();
        Long idLoja = (Long) session.getAttribute("idLoja");

        Cliente cliente = new Cliente();

        cliente.setEmail(email);
        cliente.setSobrenome(sobrenome);
        cliente.setTelefone(telefone);

        ManagerCliente managerCliente = new ManagerCliente();

        try {
            Map<String, Boolean> result = new java.util.HashMap<>(Map.ofEntries(
                    Map.entry("cadastrado", true)
            ));

            if (managerCliente.cadastrar(cliente) == null)
                result.put("cadastrar", false);

            Gson gson = new Gson();
            return gson.toJson(result);
        } catch (DadoException | PersistenceException e) {
            throw new RuntimeException(e);
        }
    }
}