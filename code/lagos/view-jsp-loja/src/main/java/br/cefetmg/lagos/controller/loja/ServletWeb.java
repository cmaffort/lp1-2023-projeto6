package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.FileOutput;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.exception.OutputException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
            case "CadastrarCliente":
                result = CadastrarCliente.execute(request);
                tipoServlet = CadastrarCliente.getTipo();
                break;
            case "CadastrarContrato":
                result = CadastrarContrato.execute(request);
                tipoServlet = CadastrarContrato.getTipo();
                break;
            case "ListarClientes":
                result = ListarClientes.execute(request);
                tipoServlet = ListarClientes.getTipo();
                break;
            case "Login":
                result = Login.execute(request);
                tipoServlet = Login.getTipo();
                break;
            default:
                result = Error.execute(request);
                tipoServlet = Error.getTipo();
        }

        switch (tipoServlet) {
            case PAGE_FORWARD_SERVLET:
                RequestDispatcher rd = request.getRequestDispatcher(result);
                rd.forward(request, response);
                break;
            case PAGE_REDIRECT_SERVLET:
                response.sendRedirect(result);
                break;
            case JSON_SERVLET:
                response.getWriter().write(result);
                break;
            case FILE_SERVLET:
                try {
                    FileOutput.writeToOutput(request.getAttribute("file"), response.getOutputStream());
                } catch (OutputException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                response.setContentType(result);
        }
    }
}
