package ru.main.services;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class SceneSwitchService {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     *
     * @param resource
     * @param event
     * @param title
     * @throws IOException
     */
    public void switchScene(String resource, ActionEvent event, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(resource));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
