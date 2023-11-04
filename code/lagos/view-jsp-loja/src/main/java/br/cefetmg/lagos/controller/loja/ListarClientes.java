package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.service.loja.ManterCliente;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class ListarClientes extends HttpServlet {
    public static TipoServlet getTipo() {
        return TipoServlet.JSONServlet;
    }

    public static String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Long idLoja = (Long) session.getAttribute("idLoja");

        ManterCliente manterCliente = new ManterCliente();

        List<Cliente> cliente = manterCliente.consultarPorLoja(idLoja);

        Gson gson = new Gson();
        return gson.toJson(cliente);
    }
}