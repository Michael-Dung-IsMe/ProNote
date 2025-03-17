package model.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchConsoleController {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public static void switchToScene_A(ActionEvent event, String fxml) throws IOException {
        root = FXMLLoader.load(SwitchConsoleController.class.getResource(fxml));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToScene_M(MouseEvent event, String fxml) throws IOException {
        root = FXMLLoader.load(SwitchConsoleController.class.getResource(fxml));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
