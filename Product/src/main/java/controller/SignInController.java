package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.user.UserManager;

import java.io.IOException;

public class SignInController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button onSignInButtonClick;

    @FXML
    private Label onSignUpClick;

    @FXML
    void initialize() {
        UserManager userManager = new UserManager();

        onSignInButtonClick.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                if (emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    alert.setContentText("You must fill all the fields");
                    alert.show();
                    return;
                }

                if (userManager.checkUserOnList(emailField.getText(), passwordField.getText())) {
                    try {
                        SwitchConsoleController.switchToScene_A(actionEvent, "home-screen.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                else {
                    alert.setContentText("Invalid email or password");
                    alert.show();
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
