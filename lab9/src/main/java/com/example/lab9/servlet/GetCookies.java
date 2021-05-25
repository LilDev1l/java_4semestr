package com.example.lab9.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookies", value = "/cookies")
public class GetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter pw = response.getWriter();
        pw.println("<html>");

        for (Cookie cookie :
                cookies) {
            pw.println("<p>" + cookie.getName() + " : " + cookie.getValue() + "</p>");
        }
        
        pw.println("</html>");
    }
}
