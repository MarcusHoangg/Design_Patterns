package mediatorchat;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements ChatMediator {
    private Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        ChatClientController receiver = clients.get(to);
        ChatClientController sender = clients.get(from);

        if (sender != null) {
            sender.receiveMessage("You -> " + to + ": " + message);
        }

        if (receiver != null) {
            receiver.receiveMessage(from + " -> You: " + message);
        } else if (sender != null) {
            sender.receiveMessage("[System] User '" + to + "' not found.");
        }
    }
}