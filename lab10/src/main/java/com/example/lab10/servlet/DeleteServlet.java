package com.example.lab10.servlet;

import com.example.lab10.db.YachtClubDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            YachtClubDAO yachtClubDAO = (YachtClubDAO) request.getServletContext().getAttribute("yachtClubDAO");
            yachtClubDAO.delete(id);
            response.sendRedirect("/lab10/auth/welcome");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
