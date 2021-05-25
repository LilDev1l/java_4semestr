package com.example.lab9.servlet;

import java.io.*;
import java.net.InetAddress;
import java.time.LocalTime;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GetDate", value = "/getDate")
public class GetDate extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocalTime date = LocalTime.now();
        InetAddress addr = InetAddress.getLocalHost();
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // getData
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body>\n" +
                "<p>Time: " + date.toString() +
                "<table border=1\n" +
                "<tr><td> Protocol    <td>" + request.getProtocol() +
                "<tr><td> IP client   <td>" + request.getRemoteAddr() +
                "<tr><td> IP server   <td>" + addr.getHostAddress() +
                "<tr><td> IP local name   <td>" + request.getLocalName() +
                "<tr><td> Port name    <td>" + request.getLocalPort() +
                "<tr><td> Method name    <td>" + request.getMethod()
        );
        out.println("</table>");
        out.println("</br><a href='/lab9'>Back</a>");
        out.println("</body></html>");
    }

}