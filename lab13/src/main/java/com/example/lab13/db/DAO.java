package com.example.lab13.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    public int insert(T entity) {
        String sql = getCreateQuery();
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, entity);
            count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public int update(T newEntity) throws Exception {
        String sql = getUpdateQuery();
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, newEntity); // заполнение аргументов запроса оставим на совесть потомков
            count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On update modify more then 1 record: " + count);
            }
        }
        return count;
    }
    public int delete(int key) throws Exception {
        String sql = getDeleteQuery();
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            count = statement.executeUpdate();
            if (count != 1) {
                throw new Exception("On delete modify more then 1 record: " + count);
            }
        }
        return count;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
