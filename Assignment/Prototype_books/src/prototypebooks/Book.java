package prototypebooks;

public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public Book clone() {
        return new Book(author, title, genre, publicationYear);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + genre + ", " + publicationYear + ")";
    }
}