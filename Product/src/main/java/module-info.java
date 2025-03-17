module com.example.pronote {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.pronote to javafx.fxml;
    exports com.example.pronote;
    exports controller;
    opens controller to javafx.fxml;
}