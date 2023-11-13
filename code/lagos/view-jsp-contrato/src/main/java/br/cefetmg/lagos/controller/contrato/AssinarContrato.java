package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class AssinarContrato {
    public static TipoServlet getTipoDoGet() {
        return TipoServlet.PAGE_FORWARD_SERVLET;
    }

    public static String doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            Contrato contrato = new Contrato();
            contrato.setDataDeCriacao(request.getParameter());
            contrato.setDocumento(request.getParameter());
            contrato.setDescricao(request.getParameter());
            contrato.setId(null);//nao sei fazer
            contrato.setTaxaDeMulta(request.getParameter());
            contrato.setNumeroDeLojas(request.getParameter());
            contrato.setPreco(request.getParameter());
            contrato.setAtivo(true);
            contrato.setPeriodicidade(request.getParameter());


        return "/assinar-contrato.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.doGet();
        }

    }
}
