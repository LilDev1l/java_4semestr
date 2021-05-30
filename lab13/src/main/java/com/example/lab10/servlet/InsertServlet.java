package com.example.lab10.servlet;

import com.example.lab10.db.YachtClubDAO;
import com.example.lab10.model.YachtClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/insert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));
            YachtClub yachtClub = new YachtClub(name, price);

            YachtClubDAO yachtClubDAO = (YachtClubDAO) req.getServletContext().getAttribute("yachtClubDAO");
            yachtClubDAO.insert(yachtClub);
            resp.sendRedirect("/lab10/auth/welcome");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/insert.jsp").forward(req, resp);
        }
    }
}
