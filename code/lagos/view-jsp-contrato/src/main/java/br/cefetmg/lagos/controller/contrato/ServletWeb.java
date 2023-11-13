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
      
        if ("GET".equals(request.getMethod()))
            switch (acao) {
                case "ListarLojas":
                    result = ListarLojas.doGet(request);
                    tipoServlet = ListarLojas.getTipoDoGet();
                    break;
                case "EditarLoja":
                    result = EditarLoja.doGet(request);
                    tipoServlet = EditarLoja.getTipoDoGet();
                    break;
                case "GetXMLLoja":
                    result = GetXMLLoja.doGet(request);
                    tipoServlet = GetXMLLoja.getTipoDoGet();
                    break;
                case "CadastrarLoja":
                    result = CadastrarLoja.doGet(request);
                    tipoServlet = CadastrarLoja.getTipoDoGet();
                    break;
                case "PersonalizarInterface":
                    result = PersonalizarInterface.doGet(request);
                    tipoServlet = PersonalizarInterface.getTipoDoGet();
                    break;
                case "AssinarContrato":
                    result = AssinarContrato.doGet(request);
                    tipoServlet = AssinarContrato.getTipoDoGet();
                    break;
                case "Home":
                    result = Home.doGet(request);
                    tipoServlet = Home.getTipoDoGet();
                    break;
                case "CriarUsuario":
                    result = CriarUsuario.doGet(request);
                    tipoServlet = CriarUsuario.getTipoDoGet();
                    break;
                case "Logout":
                    result = Logout.doGet(request);
                    tipoServlet = Logout.getTipoDoGet();
                    break;
                case "Login":
                    result = Login.doGet(request);
                    tipoServlet = Login.getTipoDoGet();
                    break;
                default:
                    result = Error.doGet(request);
                    tipoServlet = Error.getTipoDoGet();
            }
        else
            switch (acao) {
                case "EditarLoja":
                    result = EditarLoja.doPost(request);
                    tipoServlet = EditarLoja.getTipoDoPost();
                    break;
                case "CadastrarLoja":
                    result = CadastrarLoja.doPost(request);
                    tipoServlet = CadastrarLoja.getTipoDoPost();
                    break;
                case "ExcluirLoja":
                    result = ExcluirLoja.doPost(request);
                    tipoServlet = ExcluirLoja.getTipoDoPost();
                    break;
                case "CriarUsuario":
                    result = CriarUsuario.doPost(request);
                    tipoServlet = CriarUsuario.getTipoDoPost();
                    break;
                case "Login":
                    result = Login.doPost(request);
                    tipoServlet = Login.getTipoDoPost();
                    break;
                default:
                    result = Error.doGet(request);
                    tipoServlet = Error.getTipoDoGet();
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

