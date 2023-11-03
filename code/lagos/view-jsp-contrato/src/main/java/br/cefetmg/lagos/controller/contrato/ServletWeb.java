package br.cefetmg.lagos.controller.contrato;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletWeb extends HttpServlet {
    private String jsp;

    public ServletWeb() {
        jsp = "";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        String acao = request.getParameter("acao");

//        switch (acao) {
//            case "login":
//                jsp = "";
//                break;
//            case "other":
//                jsp = "";
//                break;
//        }

        jsp = "index.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
