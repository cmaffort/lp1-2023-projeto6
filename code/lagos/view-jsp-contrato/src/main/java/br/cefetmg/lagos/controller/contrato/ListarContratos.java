package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
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

public class ListarContratos extends HttpServlet {

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    protected static String doPost(HttpServletRequest request) throws ServletException, IOException {

        ManterContrato mc = new ManterContrato();
        ManterContratoAssinado mca = new ManterContratoAssinado();

        try {
            List<ContratoAssinado> contratosAss = mca.pesquisarTodos();
            List<Contrato> contratos = mc.pesquisarTodos();

            request.getSession().setAttribute("contratosAss", contratosAss);
            request.getSession().setAttribute("contratos", contratos);
            request.getSession().setAttribute("listedFlag", true);

            return "contratos.jsp";

        } catch (PersistenceException e) {
            out.println("erro post");
            return "servletweb?acao=Error";
        }

    }

    public static TipoServlet getTipoDoGet() { return TipoServlet.PAGE_FORWARD_SERVLET; }

    protected static String doGet(HttpServletRequest request) throws ServletException, IOException {

        ManterContrato mc = new ManterContrato();
        ManterContratoAssinado mca = new ManterContratoAssinado();

        try {
            List<ContratoAssinado> contratosAss = mca.pesquisarTodos();
            List<Contrato> contratos = mc.pesquisarTodos();

            request.getSession().setAttribute("contratosAss", contratosAss);
            request.getSession().setAttribute("contratos", contratos);
            request.getSession().setAttribute("listedFlag", true);

            return "contratos.jsp";

        } catch (PersistenceException e) {
            out.println("erro get");
            return "servletweb?acao=Error";
        }

    }

}