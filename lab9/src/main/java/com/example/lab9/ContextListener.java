package com.example.lab9;

import com.example.lab9.db.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {
    private UserDAO userDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=user;password=max");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        userDAO = new UserDAO(connection);

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("userDAO", userDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            userDAO.closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
