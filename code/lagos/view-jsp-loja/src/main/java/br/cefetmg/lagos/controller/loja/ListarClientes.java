package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.model.dto.loja.Cliente;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import br.cefetmg.lagos.model.service.ManagerCliente;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class ListarClientes extends HttpServlet {
    public static TipoServlet getTipo() {
        return TipoServlet.JSONServlet;
    }

    public static String execute(HttpServletRequest request)  {

        HttpSession session = request.getSession();
        Long idLoja = (Long) session.getAttribute("idLoja");

        ManagerCliente managerCliente = new ManagerCliente();

        List<Cliente> cliente = managerCliente.consultarPorLoja(idLoja);

        Gson gson = new Gson();
        return gson.toJson(cliente);
    }
}