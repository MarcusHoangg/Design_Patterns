package visitorfs;

public class Main {
    public static void main(String[] args) {
        // create directory structure
        Directory root = new Directory("root");

        Directory docs = new Directory("docs");
        Directory images = new Directory("images");
        Directory code = new Directory("code");

        docs.add(new MyFile("report.pdf", 2.5));
        docs.add(new MyFile("notes.txt", 1.2));

        images.add(new MyFile("photo.jpg", 5.0));
        images.add(new MyFile("diagram.png", 3.3));

        code.add(new MyFile("Main.java", 0.8));
        code.add(new MyFile("VisitorExample.java", 1.1));

        root.add(docs);
        root.add(images);
        root.add(code);
        root.add(new MyFile("readme.md", 0.4));

        // Visitor 1: calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total file size: " + sizeVisitor.getTotalSize() + " MB");

        // Visitor 2: search files by keyword
        SearchVisitor searchVisitor = new SearchVisitor(".java");
        root.accept(searchVisitor);

        System.out.println("\nFiles matching '.java':");
        for (MyFile file : searchVisitor.getMatchedFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSizeInMB() + " MB)");
        }
    }
}