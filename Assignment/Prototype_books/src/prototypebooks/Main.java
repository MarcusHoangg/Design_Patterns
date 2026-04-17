package prototypebooks;

public class Main {
    public static void main(String[] args) {

        Recommendation teens = new Recommendation("Teen readers");
        teens.addBook(new Book("J.K. Rowling", "Harry Potter", "Fantasy", 1997));
        teens.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopian", 2008));

        System.out.println("=== Original Recommendation ===");
        teens.display();

        Recommendation youngAdults = teens.clone();
        youngAdults.setTargetAudience("Young adult readers");
        youngAdults.addBook(new Book("George Orwell", "1984", "Dystopian", 1949));
        youngAdults.removeBookByTitle("Harry Potter");

        System.out.println("\n=== Cloned and Modified Recommendation ===");
        youngAdults.display();

        System.out.println("\n=== Original Recommendation After Clone ===");
        teens.display();
    }
}