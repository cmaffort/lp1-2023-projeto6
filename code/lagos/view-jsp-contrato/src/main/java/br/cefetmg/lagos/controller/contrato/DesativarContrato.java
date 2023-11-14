package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public class DesativarContrato extends HttpServlet {

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    protected static String doPost(HttpServletRequest request) throws ServletException, IOException {

        try {
            ManterContrato mc = new ManterContrato();
            Contrato contrato;

            long idContrato = Long.parseLong(request.getParameter("id"));

            contrato = mc.pesquisarPorId(idContrato);
            contrato.setAtivo(false);

            mc.alterar(contrato);

            return "servletweb?acao=ListarContratos";

        }
        catch (PersistenceException | NegocioException e) {
            return "servletweb?acao=Error";
        }

    }
}