package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterUsuario;
import br.cefetmg.lagos.model.service.loja.IManterFuncionario;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterFuncionario;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class EditarLoja {
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
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));
            Loja loja = new Loja();
            loja.setId(lojaId);

            if (!contratante.getManeger().isTableRelated(loja))
                return Error.execute(request);

            loja = manterLoja.pesquisarPorId(lojaId);

            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();
            IManterFuncionario manterFuncionario = new ManterFuncionario();
            UsuarioLoja chefeFiltro = new UsuarioLoja();
            chefeFiltro.setTipo(TipoFuncionario.CHEFE);
            chefeFiltro.setLoja(loja);
            // Alterar o filtro de herança para fornecer suporte à isso
            // List<UsuarioLoja> chefes = manterUsuarioLoja.filtrar(chefeFiltro, "tipo_funcionario", "loja__fk");

            request.setAttribute("loja", loja);

            return "/editar-loja.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return Error.execute(request);
        }
    }
}
