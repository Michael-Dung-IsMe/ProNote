package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.user.SwitchConsoleController;

import java.io.IOException;

public class SignInController {

    @FXML
    private TextField email;

    @FXML
    private Button onSignInButtonClick;

    @FXML
    private Label onSignUpClick;

    @FXML
    private PasswordField password;

    @FXML
    void initialize() {

        onSignInButtonClick.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                if (email.getText().isEmpty() || password.getText().isEmpty()) {
                    alert.setContentText("You must fill all the fields");
                    alert.show();
                    return;
                }

            }
        });

        onSignUpClick.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    SwitchConsoleController.switchToScene_M(mouseEvent, "sign-up.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
