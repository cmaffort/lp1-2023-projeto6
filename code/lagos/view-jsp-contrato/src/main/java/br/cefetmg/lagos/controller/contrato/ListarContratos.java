package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.util.Pair;
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

public class ListarContratos extends HttpServlet {
    public static Pair<String, TipoServlet> doPost(HttpServletRequest request) throws ServletException, IOException {

        ManterContrato mc = new ManterContrato();
        ManterContratoAssinado mca = new ManterContratoAssinado();

        try {
            List<ContratoAssinado> contratosAss = mca.pesquisarTodos();
            List<Contrato> contratos = mc.pesquisarTodos();

            request.getSession().setAttribute("contratosAss", contratosAss);
            request.getSession().setAttribute("contratos", contratos);
            request.getSession().setAttribute("listedFlag", true);

            return new Pair<>("/contratos.jsp", TipoServlet.PAGE_FORWARD_SERVLET);

        } catch (PersistenceException e) {
            out.println("erro post");
            return new Pair<>("/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }

    }

    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) throws ServletException, IOException {

        ManterContrato mc = new ManterContrato();
        ManterContratoAssinado mca = new ManterContratoAssinado();

        try {
            List<ContratoAssinado> contratosAss = mca.pesquisarTodos();
            List<Contrato> contratos = mc.pesquisarTodos();

            request.getSession().setAttribute("contratosAss", contratosAss);
            request.getSession().setAttribute("contratos", contratos);
            request.getSession().setAttribute("listedFlag", true);

            return new Pair<>("/contratos.jsp", TipoServlet.PAGE_REDIRECT_SERVLET);

        } catch (PersistenceException e) {
            out.println("erro get");
            return Error.doGet(request);
        }

    }

}