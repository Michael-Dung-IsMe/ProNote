package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.user.UserInfo;
import model.user.UserManager;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField uEmail;

    @FXML
    private PasswordField pass1;

    @FXML
    private PasswordField pass2;

    @FXML
    private Button onSignUpButtonClick;

    @FXML
    private Label onSignInClick;
    private UserManager userManager;
    private UserInfo user;

    private static boolean userExist = true;

    @FXML
    void initialize() {

        onSignInClick.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    SwitchConsoleController.switchToScene_M(event, "sign-in.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        onSignUpButtonClick.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                String validEmail = uEmail.getText().substring(uEmail.getText().indexOf("@"));

                if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || uEmail.getText().isEmpty() || pass1.getText().isEmpty() || pass2.getText().isEmpty()) {
                    alert.setContentText("You must fill all the fields");
                    alert.show();
                    return;
                }

                else if (!validEmail.equals("@gmail.com") && !validEmail.equals("@yahoo.com")) {
                    alert.setContentText("Invalid Email");
                    alert.showAndWait();
                    return;
                }

                else if (!pass1.getText().equals(pass2.getText())) {
                    alert.setContentText("Passwords do not match");
                    alert.show();
                    return;
                }

                else {
                    user = UserInfo.getInstance();
                    user.setUsername(firstName.getText() + " " + lastName.getText());
                    user.setUserEmail(uEmail.getText());
                    user.setUserPassword(pass1.getText());
                    userManager.addUser(user);
                    userExist = false;
                }
                try {
                    SwitchConsoleController.switchToScene_A(event, "home-screen.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
