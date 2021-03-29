package library;

public class Author {
    private String name;
    private String country;

    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return "Автор [Имя: " + name + "; Страна: " + country + "]";
    }
}
