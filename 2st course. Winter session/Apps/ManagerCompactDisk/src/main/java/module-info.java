module ru.kulabuhov98 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens ru.kulabuhov98 to javafx.fxml;
    exports ru.kulabuhov98;
    exports ru.kulabuhov98.controllers;
    opens ru.kulabuhov98.controllers to javafx.fxml;
}