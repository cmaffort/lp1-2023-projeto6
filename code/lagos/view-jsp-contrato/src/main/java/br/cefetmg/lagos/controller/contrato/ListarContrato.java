package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.exception.NegocioException;
import com.google.gson.Gson;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class ListarContrato {
    public static TipoServlet getTipo() {
        return TipoServlet.JSONServlet;
    }

    public static String doGet(HttpServletRequest request){
        ManterContrato manterContrato = new ManterContrato();

        try{
            List<Contrato> contratoList = manterContrato.pesquisarTodos();

            Gson gson = new Gson();

            return gson.toJson(contratoList);

        }catch (PersistenceException e){
            Gson gson = new Gson();

            return gson.toJson("Erro ao conectar com o Banco de dados.");
        }
    }
}
