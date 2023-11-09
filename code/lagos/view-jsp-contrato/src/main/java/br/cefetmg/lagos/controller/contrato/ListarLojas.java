package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;

import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.model.util.DataBaseParser;
import jakarta.servlet.http.HttpServletRequest;

public class ListarLojas {
    public static TipoServlet getTipo() {
        return TipoServlet.JSPServlet;
    }

    public static String execute(HttpServletRequest request) {
        try {
            UserSessionControl.createSession(request, (new ManterUsuario()).pesquisarPorId(2L));
            Usuario contratante = UserSessionControl.getSession(request);

            if (contratante == null)
                return Login.execute(request);

            if (!contratante.getPermicoes().contains(Permissao.GERIR_LOJAS))
                return Error.execute(request);

            IManterLoja manterLoja = new ManterLoja();
            request.setAttribute("lojas", manterLoja.pesquisarPorContratante(contratante));

            return "/listar-lojas.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.execute(request);
        }
    }


    public static void main(String[] args) throws PersistenceException {
        System.out.println(DataBaseParser.dbLojaToXML((new ManterLoja()).pesquisarPorId(1L)));
    }
}
