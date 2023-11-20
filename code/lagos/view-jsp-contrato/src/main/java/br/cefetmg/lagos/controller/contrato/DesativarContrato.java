package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public class DesativarContrato extends HttpServlet {
    protected static Pair<String, TipoServlet> doPost(HttpServletRequest request) throws ServletException, IOException {

        try {
            ManterContrato mc = new ManterContrato();
            Contrato contrato;

            long idContrato = Long.parseLong(request.getParameter("id"));

            contrato = mc.pesquisarPorId(idContrato);
            contrato.setAtivo(false);

            mc.alterar(contrato);

            return new Pair<>("/servletweb?acao=ListarContratos", TipoServlet.PAGE_REDIRECT_SERVLET);
        }
        catch (PersistenceException | NegocioException e) {
            return new Pair<>("/servletweb?acao=Error", TipoServlet.PAGE_REDIRECT_SERVLET);
        }

    }
}