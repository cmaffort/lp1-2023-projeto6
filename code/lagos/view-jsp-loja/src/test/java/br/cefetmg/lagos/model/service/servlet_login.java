package br.cefetmg.lagos.model.service;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;    
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet_login")
public class servlet_login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userStr = request.getParameter("usuario");
        String senhaStr = request.getParameter("senha");

            request.setAttribute("Usuario", userStr);
            request.setAttribute("Senha", senhaStr);

            request.getRequestDispatcher("/jsp_login.jsp").forward(request, response);

    }
}