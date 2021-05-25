package com.example.lab9.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class DAO<T extends Identified<PK>, PK extends Integer>  {
    private Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();
    public abstract String getCreateQuery();
    public abstract String getUpdateQuery();
    public abstract String getDeleteQuery();
    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T entity) throws SQLException;
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T entity) throws SQLException;

    public T getById(int key) throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }
    public List<T> getAll() {
        List<T> list = null;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public void insert(T entity) {
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, entity);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(T newEntity) throws Exception {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, newEntity); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On update modify more then 1 record: " + count);
            }
        }
    }
    public void delete(T entity) throws Exception {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, entity.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On delete modify more then 1 record: " + count);
            }
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
