package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.ManterCliente;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class ListarClientes extends HttpServlet {
    private static TipoServlet getTipoDoGet(){return TipoServlet.JSON_SERVLET;}
    
    public static Pair<String, TipoServlet> doGet(HttpServletRequest request){
        Long idLoja = (Long) request.getSession().getAttribute("idLoja");

        ManterLoja manterLoja = new ManterLoja();
        ManterCliente manterCliente = new ManterCliente();

        Gson gson = new Gson();

        try {
            Loja loja = manterLoja.pesquisarPorIdLoja(idLoja);
            List<Cliente> cliente = manterCliente.pesquisarPorLoja(loja);

            return new Pair<>(gson.toJson(cliente), getTipoDoGet());
        }catch (PersistenceException | NegocioException e){
            return new Pair<>(gson.toJson("Erro"), getTipoDoGet());
        }
    }
}