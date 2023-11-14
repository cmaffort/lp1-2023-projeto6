package br.cefetmg.lagos.controller.loja;


import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "CadastrarContrato", urlPatterns = {"/CadastrarContrato"})
public class CadastrarContrato extends HttpServlet {

    public static TipoServlet getTipo() {
        return TipoServlet.FILE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
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
        return gson.toJson(result);
        }
        catch(Exception e) {
            return "";
        }
    }

}