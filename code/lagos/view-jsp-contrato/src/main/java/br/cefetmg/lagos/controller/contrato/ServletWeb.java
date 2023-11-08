package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.TipoServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletWeb extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        acao = acao == null ? "Login" : acao;
        TipoServlet tipoServlet;
        String result;

        switch (acao) {
            case "ListarLojas":
                result = ListarLojas.execute(request);
                tipoServlet = ListarLojas.getTipo();
                break;
            case "EditarLoja":
                result = EditarLoja.execute(request);
                tipoServlet = EditarLoja.getTipo();
                break;
            case "PersonalizarInterface":
                result = PersonalizarInterface.execute(request);
                tipoServlet = PersonalizarInterface.getTipo();
                break;
            case "CriarUsuario":
                result = CriarUsuario.execute(request);
                tipoServlet = CriarUsuario.getTipo();
                break;
            default:
                result = Login.execute(request);
                tipoServlet = Login.getTipo();
                break;
        }

        if (tipoServlet == TipoServlet.JSPServlet) {
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
        } else
            response.getWriter().write(result);
    }
}

