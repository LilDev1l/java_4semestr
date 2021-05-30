package com.example.lab10.servlet;

import com.example.lab10.db.UserDAO;
import com.example.lab10.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String hashPassword = DigestUtils.md5Hex(password);

        if(login == null || password == null) {
            request.setAttribute("info", "Поля не заполнены");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {
            UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
            if (userDAO.getAll()
                    .stream()
                    .filter(u -> u.getLogin().equals(login))
                    .findFirst().orElse(null) != null) {
                request.setAttribute("info", "Пользователь с таким логином уже существует");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            } else {
                User user = new User();
                user.setLogin(login);
                user.setPassword(hashPassword);
                user.setRole(User.ROLE.USER);
                userDAO.insert(user);
                request.setAttribute("info", "Пользователь зарегистрирован");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
