package ru.itis.crocodile;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class WelcomeWindow extends Application {
    private VBox welcomeLayout;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        welcomeLayout = new VBox(10);
        welcomeLayout.setAlignment(Pos.CENTER);

        welcomeLayout.getStyleClass().addAll("p-4", "bg-light");

        Label gameTitle = new Label("Игра Крокодил");
        gameTitle.getStyleClass().add("h1");

        Spinner<Integer> roundsSpinner = new Spinner<>();
        roundsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));

        TextField joinCodeField = new TextField();
        joinCodeField.setMaxWidth(200);
        joinCodeField.setPromptText("Введите код для подключения");
        joinCodeField.getStyleClass().addAll("form-control");

        Button joinButton = new Button("Присоединиться к комнате");
        joinButton.getStyleClass().addAll("btn", "btn-primary");
        joinButton.setOnAction(e -> {
            String joinCode = joinCodeField.getText();
            joinRoom(joinCode);
        });

        Button createRoomButton = new Button("Создать новую комнату");
        createRoomButton.getStyleClass().addAll("btn", "btn-success");
        createRoomButton.setOnAction(e -> {
            int numberOfRounds = roundsSpinner.getValue();
            createNewRoom(numberOfRounds);
        });

        welcomeLayout.getChildren().addAll(
                gameTitle,
                new Label("Поле ввода кода для присоединения:"),
                joinCodeField,
                joinButton,
                new Label("Выберите количество раундов:"),
                roundsSpinner,
                createRoomButton
        );

        Scene welcomeScene = new Scene(welcomeLayout, 400, 350);
        welcomeScene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        primaryStage.setScene(welcomeScene);
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }

    private void createNewRoom(int numberOfRounds) {
        CrocodileClient crocodileClient = new CrocodileClient(true);
        Stage stage = new Stage();
        crocodileClient.start(stage);
    }

    private void joinRoom(String roomCode) {
        CrocodileClient crocodileClient = new CrocodileClient(false);
        Stage stage = new Stage();
        crocodileClient.start(stage);
    }
}
