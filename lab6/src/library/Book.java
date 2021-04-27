package library;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private Date released;

    //region Constructor
    public Book(String name, String author, Date released) {
        this.name = name;
        this.author = author;
        this.released = released;
    }
    //endregion

    public String toString() {
        return "Книга [Название: \"" + name + "\"; Автор: " + author + "; Год выпуска: " + released + "]";
    }
}
