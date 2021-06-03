package com.example.lab13.db;


import com.example.lab13.model.YachtClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YachtClubDAO extends DAO<YachtClub,Integer> {

    public YachtClubDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM YachtClub";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO YachtClub (name, price) VALUES (?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE YachtClub " +
                "SET name = ?, price  = ? " +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM YachtClub WHERE id= ?;";
    }

    @Override
    protected List<YachtClub> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<YachtClub> result = new ArrayList<YachtClub>();
        while (rs.next()) {
            YachtClub yachtClub = new YachtClub();
            yachtClub.setId(rs.getInt("id"));
            yachtClub.setName(rs.getString("name"));
            yachtClub.setPrice(rs.getInt("price"));
            result.add(yachtClub);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, YachtClub entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getPrice());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, YachtClub entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getPrice());
        statement.setInt(3, entity.getId());
    }
}
