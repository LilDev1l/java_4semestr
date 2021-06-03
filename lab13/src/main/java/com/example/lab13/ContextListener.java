package com.example.lab13;

import com.example.lab13.db.UserDAO;
import com.example.lab13.db.YachtClubDAO;

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
    private YachtClubDAO yachtClubDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) { Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        userDAO = new UserDAO(connection);
        //yachtClubDAO = new YachtClubDAO(connection);

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("userDAO", userDAO);
        //servletContext.setAttribute("yachtClubDAO", yachtClubDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            userDAO.closeConnection();
            //yachtClubDAO.closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
