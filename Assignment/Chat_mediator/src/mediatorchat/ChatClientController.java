package mediatorchat;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientController {
    private ChatClient client;
    private ChatMediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientBox;

    public ChatClientController(ChatClient client, ChatMediator mediator) {
        this.client = client;
        this.mediator = mediator;
        this.mediator.registerClient(this);
    }

    public String getUsername() {
        return client.getUsername();
    }

    public void showWindow(String[] allUsers) {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + client.getUsername());

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setPrefHeight(250);

        recipientBox = new ComboBox<>();
        for (String user : allUsers) {
            if (!user.equals(client.getUsername())) {
                recipientBox.getItems().add(user);
            }
        }
        if (!recipientBox.getItems().isEmpty()) {
            recipientBox.getSelectionModel().selectFirst();
        }

        messageField = new TextField();
        messageField.setPromptText("Type your message...");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        VBox root = new VBox(10,
                new Label("Messages:"),
                chatArea,
                new Label("Recipient:"),
                recipientBox,
                new Label("Message:"),
                messageField,
                sendButton
        );
        root.setPadding(new Insets(10));

        stage.setScene(new Scene(root, 400, 420));
        stage.show();
    }

    private void sendMessage() {
        String to = recipientBox.getValue();
        String message = messageField.getText().trim();

        if (to == null || message.isEmpty()) {
            return;
        }

        mediator.sendMessage(client.getUsername(), to, message);
        messageField.clear();
    }

    public void receiveMessage(String text) {
        chatArea.appendText(text + "\n");
    }
}