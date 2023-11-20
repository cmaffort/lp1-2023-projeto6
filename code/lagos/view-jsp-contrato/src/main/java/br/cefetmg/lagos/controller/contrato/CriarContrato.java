package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.ManterPeriodicidade;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

import static java.lang.System.out;

@WebServlet
@MultipartConfig
public class CriarContrato extends HttpServlet {
    protected static Pair<String, TipoServlet> doPost(HttpServletRequest request) throws ServletException, IOException {

        ManterContrato mc = new ManterContrato();
        ManterPeriodicidade mp = new ManterPeriodicidade();

        Contrato novoContrato = new Contrato();
        Boolean ativo;
        String descricao;
        Double preco;
        byte[] documento;
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

            ativo = true;

            descricao = request.getParameter("descricao");

            preco = Double.parseDouble(request.getParameter("preco"));

            //implementar tranferencia do documento

            /*
            InputStream inputStream = null; // input stream of the upload file

            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("documento");
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
                documento = new SerialBlob(inputStream.readAllBytes());
            } else {
                documento = null;
            }
            */

            documento = null;

            taxaDeMulta = Float.parseFloat(request.getParameter("multa"));

            numeroDeLojas = Integer.parseInt(request.getParameter("numeroLojas"));

            long millis=System.currentTimeMillis();
            dataDeCriacao = new Date(millis);

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

            return new Pair<>("/servletweb?acao=ListarContratos", TipoServlet.PAGE_REDIRECT_SERVLET);

        } catch (PersistenceException | NegocioException e) {
            return new Pair<>("/servletweb?acao=ListarContratos", TipoServlet.PAGE_REDIRECT_SERVLET);
        }

    }
}
