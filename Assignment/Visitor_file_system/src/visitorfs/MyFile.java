package visitorfs;

public class MyFile implements FileSystemElement {
    private String name;
    private double sizeInMB;

    public MyFile(String name, double sizeInMB) {
        this.name = name;
        this.sizeInMB = sizeInMB;
    }

    public double getSizeInMB() {
        return sizeInMB;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}