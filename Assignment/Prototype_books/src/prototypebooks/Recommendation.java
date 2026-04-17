package prototypebooks;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(this.targetAudience);
        for (Book book : books) {
            copy.addBook(book.clone());
        }
        return copy;
    }

    public void display() {
        System.out.println("Target audience: " + targetAudience);
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}