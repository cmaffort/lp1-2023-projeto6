package com.br.cefetmg.lagos;

import java.io.IOException;

import br.cefetmg.lagos.model.dto.loja.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import br.cefetmg.lagos.model.service.ManagerCliente;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@WebServlet(name = "ListarClientes", urlPatterns = {"/ListarClientes"})
public class ListarClientes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            HttpSession session = request.getSession();
            Long idLoja = (Long) session.getAttribute("idLoja");

            ManagerCliente managerCliente = new ManagerCliente();

            List<Cliente> cliente = managerCliente.consultarPorLoja(idLoja);

            Gson gson = new Gson();
            String jsonClientes = gson.toJson(cliente);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonClientes);
    }
}