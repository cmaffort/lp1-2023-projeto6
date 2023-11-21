package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.FileOutput;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.exception.OutputException;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig
public class ServletWeb extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        acao = acao == null ? "Login" : acao;
        Pair<String, TipoServlet> result;

        if ("GET".equals(request.getMethod()))
            result = switch (acao) {
                case "CadastrarContrato" -> CadastrarContrato.doGet(request);
                case "Login" -> Login.doGet(request);
                case "Home" -> Home.doGet(request);
                default -> Error.doGet(request);
            };
        else
            result = switch (acao) {
                case "CadastrarCliente" -> CadastrarCliente.doPost(request);
                case "ListarClientes" -> ListarClientes.doPost(request);
                case "Login" -> Login.doPost(request);
                default -> Error.doGet(request);
            };

        switch (result.second()) {
            case PAGE_FORWARD_SERVLET:
                RequestDispatcher rd = request.getRequestDispatcher(result.first());
                rd.forward(request, response);
                break;
            case PAGE_REDIRECT_SERVLET:
                response.sendRedirect(result.first());
                break;
            case JSON_SERVLET:
                response.getWriter().write(result.first());
                break;
            case FILE_SERVLET:
                try {
                    FileOutput.writeToOutput(request.getAttribute("file"), response.getOutputStream());
                } catch (OutputException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                response.setContentType(result.first());
        }
    }
}
