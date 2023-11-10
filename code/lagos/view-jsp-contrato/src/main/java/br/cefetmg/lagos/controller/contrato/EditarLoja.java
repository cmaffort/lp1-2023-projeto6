package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.controller.contrato.util.UserSessionControl;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.service.contrato.IManterLoja;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.IManterFuncionario;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterFuncionario;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class EditarLoja {
    public static TipoServlet getTipo() {
        return TipoServlet.PAGE_SERVLET;
    }

    public static String execute(HttpServletRequest request) {
        if ("GET".equals(request.getMethod()))
            return doGet(request);
        else
            return doPost(request);
    }

    public static String doGet(HttpServletRequest request) {
        try {
            Usuario contratante = UserSessionControl.getSession(request);
            String redirectJSP = UserSessionControl.getRedirectIfUserNotOk(contratante, Permissao.GERIR_LOJAS);
            if (redirectJSP != null)
                return redirectJSP;

            IManterLoja manterLoja = new ManterLoja();
            Long lojaId = Long.valueOf(request.getParameter("lojaId"));
            Loja loja = manterLoja.pesquisarPorId(lojaId);

            if (!loja.getUsuarioAsLong().equals(contratante.getId()))
                return "/404.jsp";

            IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();
            IManterFuncionario manterFuncionario = new ManterFuncionario();
            UsuarioLoja chefeFiltro = new UsuarioLoja();
            chefeFiltro.setTipo(TipoFuncionario.CHEFE);
            chefeFiltro.setLoja(loja);

            List<Funcionario> funcionariosChefe = manterFuncionario
                    .filtrar(chefeFiltro.getFuncionario(), "tipo_funcionario", "loja__fk");
            List<UsuarioLoja> chefes = manterUsuarioLoja
                    .pesquisarPorQualquerDosRelacionados(funcionariosChefe.toArray(new Funcionario[0]));

            request.setAttribute("loja", loja);
            request.setAttribute("chefes", chefes);

            return "/editar-loja.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/404.jsp";
        }
    }

    public static String doPost(HttpServletRequest request) {
        // Implementar lógica de salvar loja
        return "/editar-loja.jsp";
    }
}
