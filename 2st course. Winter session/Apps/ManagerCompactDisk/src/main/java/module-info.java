module ru.main {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires mysql.connector.j;

    opens ru.main to javafx.fxml;
    exports ru.main;
    exports ru.main.controllers;
    opens ru.main.controllers to javafx.fxml;

    opens ru.main.models to javafx.base;
    exports ru.main.models;
}