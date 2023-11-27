package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import br.cefetmg.lagos.model.dto.Periodicidade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.sql.Date;

@WebServlet(name = "CadastrarContrato", urlPatterns = {"/CadastrarContrato"})
public class CadastrarContrato extends HttpServlet {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
        Long id = Long.parseLong(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        
        Periodicidade periodicidade = new Periodicidade();
        periodicidade.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
        periodicidade.setQuantidadeDiasPorPeriodo(Integer.parseInt(request.getParameter("quantidadeDiasPorPeriodo")));
        
        InputStream inputStream = null;
        Part documentoPart = request.getPart("documento");
        if (documentoPart != null) {
            inputStream = documentoPart.getInputStream();
        }
        
        float taxaDeMulta = Float.parseFloat(request.getParameter("taxaDeMulta"));
        Integer numeroDeLojas = Integer.parseInt(request.getParameter("numeroDeLojas"));
        
        String dataDeCriacaoStr = request.getParameter("dataDeCriacao");
        Date dataDeCriacao = Date.valueOf(dataDeCriacaoStr);
        
        HttpSession session = request.getSession();
        Long idLoja = (Long) session.getAttribute("idLoja");

        Contrato contrato = new Contrato();

        contrato.setId(id);
        contrato.setDescricao(descricao);
        contrato.setPreco(preco);
        contrato.setPeriodicidade(periodicidade);
        
        contrato.setDocumento(inputStream.readAllBytes());
        contrato.setTaxaDeMulta(taxaDeMulta);
        contrato.setNumeroDeLojas(numeroDeLojas);
        contrato.setDataDeCriacao(dataDeCriacao);
        
        ManterContrato manterContrato = new ManterContrato();

        Long result = manterContrato.cadastrar(contrato);

        Gson gson = new Gson();
        return new Pair<>(gson.toJson(result), TipoServlet.JSON_SERVLET);
        }
        catch(Exception e) {
            return Error.doGet(request);
        }
    }

}