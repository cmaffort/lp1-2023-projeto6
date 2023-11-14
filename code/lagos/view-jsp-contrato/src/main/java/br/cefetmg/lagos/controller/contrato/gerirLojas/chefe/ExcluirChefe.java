package br.cefetmg.lagos.controller.contrato.gerirLojas.chefe;

import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public class ExcluirChefe {
    public static TipoServlet getTipoDoPost() {
        return TipoServlet.JSON_SERVLET;
    }

    public static String doPost(HttpServletRequest request) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Map<String, String> result = new java.util.HashMap<>(Map.of("redirect", "/servletweb?acao=Error"));

        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null) {
                result.put("redirect", redirectJSP);
                return gson.toJson(result).replace("\\\\", "\\");
            }

            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();

            Long chefeId = Long.valueOf(request.getParameter("chefeId"));

            UsuarioLoja chefe = manterUsuarioLoja.pesquisarPorId(chefeId);
            Loja loja = chefe.getLoja();

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return gson.toJson(result).replace("\\\\", "\\");

            manterUsuarioLoja.excluir(chefe);

            result.put("redirect", "/servletweb?acao=EditarLoja&lojaId=" + loja.getId());
            return gson.toJson(result).replace("\\\\", "\\");
        } catch (Exception e) {
            e.printStackTrace();
            return gson.toJson(result).replace("\\\\", "\\");
        }
    }
}
