package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
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
        TipoServlet tipoServlet;
        String result;

        switch (acao) {
            case "CadastrarCliente":
                result = CadastrarCliente.execute(request);
                tipoServlet = CadastrarCliente.getTipo();
                break;
            case "ListarClientes":
                result = ListarClientes.execute(request);
                tipoServlet = ListarClientes.getTipo();
                break;
            default:
                result = Login.execute(request);
                tipoServlet = Login.getTipo();
                break;
        }

        if (tipoServlet == TipoServlet.PAGE_SERVLET) {
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
        } else
            response.getWriter().write(result);
    }
}
