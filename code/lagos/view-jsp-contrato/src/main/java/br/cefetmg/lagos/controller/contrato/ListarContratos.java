package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.exception.NegocioException;
import jakarta.jws.WebService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import static java.lang.System.out;

@WebServlet(name="ListarContratos", urlPatterns= {"/listarContratos"})
public class ListarContratos extends HttpServlet {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManterContrato mc = new ManterContrato();
        ManterContratoAssinado mca = new ManterContratoAssinado();

        try {
            List<ContratoAssinado> contratosAss = mca.pesquisarTodos();
            List<Contrato> contratos = mc.pesquisarTodos();

            request.getSession().setAttribute("contratosAss", contratosAss);
            request.getSession().setAttribute("contratos", contratos);

            RequestDispatcher RD = request.getRequestDispatcher("/contratos.jsp");

            RD.forward(request, response);

        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }

    }
}