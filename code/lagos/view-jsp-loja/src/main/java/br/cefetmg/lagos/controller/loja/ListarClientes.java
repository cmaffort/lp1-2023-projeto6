package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.service.loja.old.ManterCliente;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class ListarClientes extends HttpServlet {
    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Long idLoja = (Long) session.getAttribute("idLoja");

        ManterCliente manterCliente = new ManterCliente();

        List<Cliente> cliente = manterCliente.consultarPorLoja(idLoja);

        Gson gson = new Gson();
        return new Pair<>(gson.toJson(cliente), TipoServlet.JSON_SERVLET);
    }
}