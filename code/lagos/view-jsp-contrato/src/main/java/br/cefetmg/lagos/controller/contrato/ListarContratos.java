package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.UserSessionControl;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterContrato;
import br.cefetmg.lagos.model.service.contrato.ManterContratoAssinado;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public class ListarContratos extends HttpServlet {

    public static TipoServlet getTipoDoPost() {
        return TipoServlet.JSON_SERVLET;
    }

    public static Pair<String, TipoServlet> executeActionListarContratos(HttpServletRequest request){
        ManterContrato manterContrato = new ManterContrato();
        Gson gson = new Gson();

        List<Contrato> contratoList = manterContrato.pesquisarPorAtivo();

        String jsonContratosList = gson.toJson(contratoList);

        return new Pair<>(jsonContratosList, TipoServlet.JSON_SERVLET);
    }

    protected static Pair<String, TipoServlet> doPost(HttpServletRequest request) throws ServletException, IOException {
        return  executeActionListarContratos(request);
    }

    public static TipoServlet getTipoDoGet() { return TipoServlet.JSON_SERVLET; }

    protected static Pair<String, TipoServlet> doGet(HttpServletRequest request) throws ServletException, IOException {
        return executeActionListarContratos(request);
    }

}