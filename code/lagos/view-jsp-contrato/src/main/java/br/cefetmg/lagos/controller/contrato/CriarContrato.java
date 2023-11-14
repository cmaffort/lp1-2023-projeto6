package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.ManterPeriodicidade;
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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

@WebServlet(name="CriarContrato", urlPatterns= {"/criarContrato"})
public class CriarContrato extends HttpServlet {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ManterContrato mc = new ManterContrato();
        ManterPeriodicidade mp = new ManterPeriodicidade();

        Contrato novoContrato = new Contrato();
        Boolean ativo;
        String descricao;
        Double preco;
        Blob documento;
        Float taxaDeMulta;
        Integer numeroDeLojas;
        Date dataDeCriacao;

        Periodicidade periodicidade = new Periodicidade();
        int numeroPeriodos;
        int diasPorPeriodo;


        Long periodicidadeId;
        Long contratoId;

        try {

            numeroPeriodos = Integer.parseInt(request.getParameter("numeroPeriodos"));
            diasPorPeriodo = Integer.parseInt(request.getParameter("tamanhoPeriodos"));

            periodicidade.setPeriodo(numeroPeriodos);
            periodicidade.setQuantidadeDiasPorPeriodo(diasPorPeriodo);
            periodicidade.setId((long) -1);
            periodicidadeId = (long) 0;

            for (Periodicidade p : mp.pesquisarTodos()) {
                if ((Objects.equals(periodicidade.getPeriodo(), p.getPeriodo())) &&
                (Objects.equals(periodicidade.getQuantidadeDiasPorPeriodo(), p.getQuantidadeDiasPorPeriodo()))) {
                    periodicidade.setId(p.getId());
                }

                periodicidadeId++;

            }
            if(periodicidade.getId() == -1) {

                periodicidade.setId(periodicidadeId);
                mp.cadastrar(periodicidade);

            }

            ativo = false;
            descricao = request.getParameter("descricao");
            preco = Double.parseDouble(request.getParameter("preco"));
            //implementar tranferencia do documento
            documento = null;
            taxaDeMulta = Float.parseFloat(request.getParameter("multa"));
            numeroDeLojas = Integer.parseInt(request.getParameter("numeroLojas"));

            String dateParam = request.getParameter("dataCriacao");
            if (dateParam==null) {

                dateParam = "2023-00-00";

            }

            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(dateParam);
            dataDeCriacao = new Date(date.getTime());

            novoContrato.setAtivo(ativo);
            novoContrato.setDescricao(descricao);
            novoContrato.setPreco(preco);
            novoContrato.setDocumento(documento);
            novoContrato.setTaxaDeMulta(taxaDeMulta);
            novoContrato.setNumeroDeLojas(numeroDeLojas);
            novoContrato.setDataDeCriacao(dataDeCriacao);
            novoContrato.setPeriodicidade(periodicidade);

            contratoId = (long) 0;
            for (Contrato c:
                 mc.pesquisarTodos()) {
                contratoId++;
            }

            novoContrato.setId(contratoId);

            mc.cadastrar(novoContrato);

            RequestDispatcher RD = request.getRequestDispatcher("/listarContratos");

            RD.forward(request, response);

        } catch (PersistenceException | NegocioException | ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
