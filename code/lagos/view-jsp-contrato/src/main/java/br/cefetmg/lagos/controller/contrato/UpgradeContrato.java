package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.exception.NegocioException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet(name="UpgradeContrato", urlPatterns= {"/upgradecontrato"})
public class UpgradeContrato extends HttpServlet {

    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            ManterContratoAssinado mca = new ManterContratoAssinado();
            ManterContrato mc = new ManterContrato();
            List<ContratoAssinado> contratosAss = mca.pesquisarTodos();

            double preco = Double.parseDouble(request.getParameter("valor"));
            Integer lojas = Integer.parseInt(request.getParameter("lojas"));

            for (ContratoAssinado contratos : contratosAss){
                if (contratos.getUsuario().getId().equals(Long.parseLong(request.getParameter("usuario")))){
                    preco = preco + contratos.getContrato().getPreco();
                    lojas = lojas + contratos.getContrato().getNumeroDeLojas();
                    contratos.getContrato().setPreco(preco);
                    contratos.getContrato().setNumeroDeLojas(lojas);
                    mc.alterar(contratos.getContrato());
                    request.getSession().setAttribute("contrato", contratos);
                }
                RequestDispatcher RD = request.getRequestDispatcher("/visualizar-contrato.jsp");
                request.getSession().setAttribute("usuarioID", request.getParameter("usuario"));

                RD.forward(request,response);

            }
        } catch (PersistenceException | NegocioException e) {
            throw new RuntimeException(e);
        }
    }}