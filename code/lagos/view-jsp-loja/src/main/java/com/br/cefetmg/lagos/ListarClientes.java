package com.br.cefetmg.lagos.model.service;

import java.io.IOException;

import br.cefetmg.lagos.model.dto.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import br.cefetmg.lagos.model.service.ManagerCliente;
import java.util.List;

@WebServlet(name = "ListarClientes", urlPatterns = {"/ListarClientes"})
public class ListarClientes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            Gson gson = new Gson();
            String objetoJson = gson.fromJson(request.toString(), String.class);

            ManagerCliente cliente = new ManagerCliente();
            List<Cliente> listaCliente = cliente.pesquisar();
            List<Cliente> listaClienteResponse;

            for(int i = 0; i < listaCliente.size(); i++){

                if(listaCliente.get(i).getId().toString().equals(objetoJson))
                    listaClienteResponse.add(listaCliente.get(i));

                else if(listaCliente.get(i).getEmail().equals(objetoJson))
                    listaClienteResponse.add(listaCliente.get(i));

                else if (listaCliente.get(i).getNome().equals(objetoJson))
                    listaClienteResponse.add(listaCliente.get(i));

                else if (listaCliente.get(i).getSobrenome().equals(objetoJson))
                    listaClienteResponse.add(listaCliente.get(i));

                else if(listaCliente.get(i).getTelefone().toString().equals(objetoJson))
                    listaClienteResponse.add(listaCliente.get(i));
            }



            String JSONClientesResponse = new gson.toJson(listaClienteResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSONClientesResponse);
    }
}