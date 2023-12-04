package br.cefetmg.lagos.controller.contrato;

import br.cefetmg.lagos.controller.contrato.gerirLojas.*;
import br.cefetmg.lagos.controller.contrato.gerirLojas.chefe.CadastrarChefe;
import br.cefetmg.lagos.controller.contrato.gerirLojas.chefe.ExcluirChefe;
import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.controller.util.FileOutput;

import br.cefetmg.lagos.controller.util.exception.OutputException;
import br.cefetmg.lagos.util.Pair;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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
                case "ListarLojas" -> ListarLojas.doGet(request);
                case "EditarLoja" -> EditarLoja.doGet(request);
                case "GetXMLLoja" -> GetXMLLoja.doGet(request);
                case "CadastrarLoja" -> CadastrarLoja.doGet(request);
                case "CadastrarChefe" -> CadastrarChefe.doGet(request);
                case "PersonalizarInterface" -> PersonalizarInterface.doGet(request);
                case "GetLogoInterface" -> GetLogoInterface.doGet(request);
                case "AssinarContrato" -> AssinarContrato.doGet(request);
                case "Home" -> Home.doGet(request);
                case "CriarUsuario" -> CriarUsuario.doGet(request);
                case "ListarContratos" -> ListarContratos.doGet(request);
                case "Logout" -> Logout.doGet(request);
                case "Login" -> Login.doGet(request);
                default -> Error.doGet(request);
            };
        else
            result = switch (acao) {
                case "AssinarContrato" -> AssinarContrato.doPost(request);
                case "EditarLoja" -> EditarLoja.doPost(request);
                case "CadastrarLoja" -> CadastrarLoja.doPost(request);
                case "ExcluirLoja" -> ExcluirLoja.doPost(request);
                case "CadastrarChefe" -> CadastrarChefe.doPost(request);
                case "ExcluirChefe" -> ExcluirChefe.doPost(request);
                case "PersonalizarInterface" -> PersonalizarInterface.doPost(request);
                case "CriarUsuario" -> CriarUsuario.doPost(request);
                case "CriarContrato" -> CriarContrato.doPost(request);
                case "ListarContratos" -> ListarContratos.doPost(request);
                case "DesativarContrato" -> DesativarContrato.doPost(request);
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

