package com.example.lab10.servlet;

import com.example.lab10.db.YachtClubDAO;
import com.example.lab10.model.YachtClub;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            YachtClubDAO yachtClubDAO = (YachtClubDAO) request.getServletContext().getAttribute("yachtClubDAO");
            YachtClub yachtClub = yachtClubDAO.getById(id);
            if(yachtClub!=null) {
                request.setAttribute("yachtClub", yachtClub);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));

            YachtClubDAO yachtClubDAO = (YachtClubDAO) request.getServletContext().getAttribute("yachtClubDAO");
            YachtClub yachtClub = new YachtClub(id, name, price);
            yachtClubDAO.update(yachtClub);
            response.sendRedirect("/lab10/auth/welcome");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
