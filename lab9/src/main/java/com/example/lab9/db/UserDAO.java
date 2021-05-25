package com.example.lab9.db;

import com.example.lab9.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User, Integer>{

    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "use Java_EE;\n" +
                "SELECT * FROM Users";
    }

    @Override
    public String getCreateQuery() {
        return "use Java_EE;\n" +
                "INSERT INTO Users (login, password, role) VALUES (?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "use Java_EE;\n" +
                "UPDATE Users\n" +
                "SET login = ?, password  = ?, role = ?\n" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "use Java_EE;\n" +
                "DELETE FROM Users WHERE id= ?;";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<User> result = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setRole(User.ROLE.valueOf(rs.getString("role")));
            result.add(user);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User entity) throws SQLException {
        statement.setString(1, entity.getLogin());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getRole().name());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User entity) throws SQLException {
        statement.setString(1, entity.getLogin());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getRole().name());
        statement.setInt(4, entity.getId());
    }
}
