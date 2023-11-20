package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.old.ManterCliente;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Map;

public class CadastrarCliente {
    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {
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

        ManterCliente manterCliente = new ManterCliente();

        try {
            Map<String, Boolean> result = new java.util.HashMap<>(Map.ofEntries(
                    Map.entry("cadastrado", true)
            ));

            if (manterCliente.cadastrar(cliente) == null)
                result.put("cadastrar", false);

            Gson gson = new Gson();
            return new Pair<>(gson.toJson(result), TipoServlet.JSON_SERVLET);
        } catch (NegocioException | PersistenceException e) {
            throw new RuntimeException(e);
        }
    }
}