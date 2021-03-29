package library;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private Date released;

    public Book(String name, String author, Date released) {
        this.name = name;
        this.author = author;
        this.released = released;
    }

    public String toString() {
        return "Книга [Название: \"" + name + "\"; Автор: " + author + "; Год выпуска: " + released + "]";
    }
}
