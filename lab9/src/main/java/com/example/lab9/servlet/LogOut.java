package com.example.lab9.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOut", value = "/logout")
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();

        session.removeAttribute("login");
        session.removeAttribute("password");
        session.removeAttribute("role");

        response.sendRedirect("auth");
    }
}
