package proxy_document;

import java.time.LocalDateTime;

public class Document implements IDocument {
    private String id;
    private String content;
    private LocalDateTime createdAt;

    public Document(String id, String content) {
        this.id = id;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public String getCreationDate() {
        return createdAt.toString();
    }
}