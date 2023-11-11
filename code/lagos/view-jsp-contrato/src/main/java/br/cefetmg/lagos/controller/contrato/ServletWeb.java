package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.FileOutput;

import br.cefetmg.lagos.controller.util.exception.OutputException;
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
            case "GetXMLLoja":
                result = GetXMLLoja.execute(request);
                tipoServlet = GetXMLLoja.getTipo();
                break;
            case "SalvarLoja":
                result = SalvarLoja.execute(request);
                tipoServlet = SalvarLoja.getTipo();
                break;
            case "PersonalizarInterface":
                result = PersonalizarInterface.execute(request);
                tipoServlet = PersonalizarInterface.getTipo();
                break;
            case "AssinarContrato":
                result = AssinarContrato.execute(request);
                tipoServlet = AssinarContrato.getTipo();
                break;
            case "Home":
                result = Home.execute(request);
                tipoServlet = Home.getTipo();
                break;
            case "CriarUsuario":
                result = CriarUsuario.execute(request);
                tipoServlet = CriarUsuario.getTipo();
                break;
            case "Logout":
                result = Logout.execute(request);
                tipoServlet = Logout.getTipo();
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
            case PAGE_SERVLET:
                RequestDispatcher rd = request.getRequestDispatcher(result);
                rd.forward(request, response);
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

