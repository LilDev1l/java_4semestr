import Library.Author;
import Library.Book;
import db.DBHelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBHelper helper = new DBHelper();

        System.out.println("\nПЕРВЫЙ запрос");
        Statement st = helper.getStatement();
        ArrayList<Book> books = helper.getBooksReleasedCurrentYear(st);
        for (var book : books) {
            System.out.println(book);
        }

        System.out.println("\nДО добавления автора");
        ArrayList<Author> authors = helper.getInfoAuthor(st);
        for (var author : authors) {
            System.out.println(author);
        }

        PreparedStatement ps = helper.getPreparedStatement("INSERT INTO author VALUES (?,?)");
        helper.insertAuthor(ps, new Author("Лермонтов", "Россия"));
        helper.closeStatement(ps);

        System.out.println("\nПОСЛЕ добавления автора");
        authors = helper.getInfoAuthor(st);
        for (var author : authors) {
            System.out.println(author);
        }
        helper.closeStatement(st);

        helper.closeConnection();
    }
}
