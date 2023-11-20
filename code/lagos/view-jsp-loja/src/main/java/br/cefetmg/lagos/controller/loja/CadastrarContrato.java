package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "CadastrarContrato", urlPatterns = {"/CadastrarContrato"})
public class CadastrarContrato extends HttpServlet {
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request) {
        try {
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        //double preco = request.getParameter("preco");
        String periodicidade = request.getParameter("periodicidade");

        HttpSession session = request.getSession();
        Long idLoja = (Long) session.getAttribute("idLoja");

        Contrato contrato = new Contrato();

        //contrato.setTitulo(titulo);
        contrato.setDescricao(descricao);
        //contrato.setPreco(preco);
        //contrato.setPeriodicidade(periodicidade);

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