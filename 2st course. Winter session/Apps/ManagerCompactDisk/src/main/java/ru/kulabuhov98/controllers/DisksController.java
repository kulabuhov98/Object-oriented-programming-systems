package ru.kulabuhov98.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisksController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}