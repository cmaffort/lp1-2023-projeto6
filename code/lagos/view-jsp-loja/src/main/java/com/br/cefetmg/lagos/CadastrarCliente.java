package com.br.cefetmg.lagos;

import java.io.IOException;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.service.exception.DadoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.service.ManagerCliente;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import java.util.List;

@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                    managerCliente.cadastrar(cliente);
            } catch (DadoException | PersistenceException e) {
                    throw new RuntimeException(e);
            }
    }
}