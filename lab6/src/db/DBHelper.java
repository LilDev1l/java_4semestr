package db;

import library.Author;
import library.Book;

import java.sql.*;
import java.util.ArrayList;

public class DBHelper {
    private Connection connect;

    public DBHelper() throws SQLException {
        connect = ConnectorDB.getConnection();
    }

    //region PreparedStatement
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connect.prepareStatement(query);
    }
    public void closeStatement(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    public void insertAuthor(PreparedStatement ps, Author author) throws SQLException {
        ps.setString(1, author.getName());
        ps.setString(2, author.getCountry());
        ps.executeUpdate();
    }
    //endregion
    //region Statement
    public Statement getStatement() throws SQLException {
        return connect.createStatement();
    }
    public ArrayList<Book> getBooksReleasedCurrentYear(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM book WHERE year(released) = year(current_date)");

        ArrayList<Book> books = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            String author = rs.getString(2);
            Date released = rs.getDate(3);
            books.add(new Book(name, author, released));
        }
        return books;
    }
    public ArrayList<Author> getInfoAuthor(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM author");

        ArrayList<Author> authors = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            String country = rs.getString(2);
            authors.add(new Author(name, country));
        }
        return authors;
    }

    public void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }
    //endregion

    public void closeConnection() throws SQLException {
        connect.close();
    }
}
