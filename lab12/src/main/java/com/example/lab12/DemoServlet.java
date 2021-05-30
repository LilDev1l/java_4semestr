package com.example.lab12;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@WebServlet(name = "DemoServlet", value = "/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Яблоко");
        strings.add("Груша");
        request.setAttribute("items", strings);

        getServletContext().getRequestDispatcher("/demo.jsp").forward(request, response);
    }
}
