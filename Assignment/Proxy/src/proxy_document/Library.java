package proxy_document;

import java.util.*;

public class Library {

    private Map<String, IDocument> documents = new HashMap<>();

    public void addDocument(String id, IDocument doc) {
        documents.put(id, doc);
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}