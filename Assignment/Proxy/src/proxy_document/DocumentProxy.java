package proxy_document;

public class DocumentProxy implements IDocument {

    private Document realDocument;
    private AccessControlService accessService;

    public DocumentProxy(Document document) {
        this.realDocument = document;
        this.accessService = AccessControlService.getInstance();
    }

    @Override
    public String getContent(User user) {
        if (accessService.isAllowed(user.getUsername(), realDocument.getId())) {
            System.out.println("[Proxy] Access granted to " + user.getUsername());
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException(
                    "[Proxy] Access denied for " + user.getUsername()
            );
        }
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate(); // không check quyền
    }
}