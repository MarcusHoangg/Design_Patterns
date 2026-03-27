package proxy_document;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");

        // Documents
        Document doc1 = new Document("doc1", "Public content");
        Document doc2 = new Document("doc2", "Secret content");

        // Proxy (protected)
        DocumentProxy protectedDoc = new DocumentProxy(doc2);

        library.addDocument("doc1", doc1);          // public
        library.addDocument("doc2", protectedDoc);  // protected
        // Grant
        AccessControlService.getInstance().grantAccess("alice", "doc2");

        // TEST
        System.out.println("=== Alice reads doc2 ===");
        System.out.println(library.getDocument("doc2").getContent(alice));

        System.out.println("\n=== Bob tries doc2 ===");
        try {
            System.out.println(library.getDocument("doc2").getContent(bob));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Public doc ===");
        System.out.println(library.getDocument("doc1").getContent(bob));
    }
}