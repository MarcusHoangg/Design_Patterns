package mediatorchat;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoom();

        String[] users = {"Alice", "Bob", "Charlie"};

        ChatClientController alice = new ChatClientController(new ChatClient("Alice"), mediator);
        ChatClientController bob = new ChatClientController(new ChatClient("Bob"), mediator);
        ChatClientController charlie = new ChatClientController(new ChatClient("Charlie"), mediator);

        alice.showWindow(users);
        bob.showWindow(users);
        charlie.showWindow(users);
    }

    public static void main(String[] args) {
        launch();
    }
}