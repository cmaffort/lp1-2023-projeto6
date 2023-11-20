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
            switch (acao) {
                case "ListarLojas":
                    result = ListarLojas.doGet(request);
                    break;
                case "EditarLoja":
                    result = EditarLoja.doGet(request);
                    break;
                case "GetXMLLoja":
                    result = GetXMLLoja.doGet(request);
                    break;
                case "CadastrarLoja":
                    result = CadastrarLoja.doGet(request);
                    break;
                case "CadastrarChefe":
                    result = CadastrarChefe.doGet(request);
                    break;
                case "PersonalizarInterface":
                    result = PersonalizarInterface.doGet(request);
                    break;
                case "GetLogoInterface":
                    result = GetLogoInterface.doGet(request);
                    break;
                case "AssinarContrato":
                    result = AssinarContrato.doGet(request);
                    break;
                case "Home":
                    result = Home.doGet(request);
                    break;
                case "CriarUsuario":
                    result = CriarUsuario.doGet(request);
                    break;
                case "ListarContratos":
                    result = ListarContratos.doGet(request);
                    break;
                case "Logout":
                    result = Logout.doGet(request);
                    break;
                case "Login":
                    result = Login.doGet(request);
                    break;
                case "LoginLoja":
                    result = LoginLoja.doGet(request);
                    break;
                default:
                    result = Error.doGet(request);
            }
        else
            switch (acao) {
                case "EditarLoja":
                    result = EditarLoja.doPost(request);
                    break;
                case "CadastrarLoja":
                    result = CadastrarLoja.doPost(request);
                    break;
                case "ExcluirLoja":
                    result = ExcluirLoja.doPost(request);
                    break;
                case "CadastrarChefe":
                    result = CadastrarChefe.doPost(request);
                    break;
                case "ExcluirChefe":
                    result = ExcluirChefe.doPost(request);
                    break;
                case "PersonalizarInterface":
                    result = PersonalizarInterface.doPost(request);
                    break;
                case "CriarUsuario":
                    result = CriarUsuario.doPost(request);
                    break;
                case "CriarContrato":
                    result = CriarContrato.doPost(request);
                    break;
                case "ListarContratos":
                    result = ListarContratos.doPost(request);
                    break;
                case "DesativarContrato":
                    result = DesativarContrato.doPost(request);
                    break;
                case "Login":
                    result = Login.doPost(request);
                    break;
                default:
                    result = Error.doGet(request);
            }

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

