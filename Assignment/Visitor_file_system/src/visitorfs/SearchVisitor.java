package visitorfs;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    private List<MyFile> matchedFiles;

    public SearchVisitor(String keyword) {
        this.keyword = keyword.toLowerCase();
        this.matchedFiles = new ArrayList<>();
    }

    public List<MyFile> getMatchedFiles() {
        return matchedFiles;
    }

    @Override
    public void visit(MyFile file) {
        if (file.getName().toLowerCase().contains(keyword)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }
}