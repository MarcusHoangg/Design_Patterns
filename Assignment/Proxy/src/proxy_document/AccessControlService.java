package proxy_document;

import java.util.*;

public class AccessControlService {

    private static AccessControlService instance;
    private Map<String, Set<String>> permissions;

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String username, String documentId) {
        permissions.putIfAbsent(documentId, new HashSet<>());
        permissions.get(documentId).add(username);
    }

    public boolean isAllowed(String username, String documentId) {
        return permissions.containsKey(documentId) &&
                permissions.get(documentId).contains(username);
    }
}