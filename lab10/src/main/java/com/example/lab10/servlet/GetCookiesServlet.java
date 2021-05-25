package com.example.lab10.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "GetCookiesServlet", value = "/cookies")
public class GetCookiesServlet extends HttpServlet {
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
