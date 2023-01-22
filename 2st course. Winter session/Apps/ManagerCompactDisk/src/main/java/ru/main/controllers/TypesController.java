package ru.main.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.main.configs.DatabaseConfig;
import ru.main.models.TypesModel;
import ru.main.services.DatabaseService;
import ru.main.services.GetConnectionService;
import ru.main.services.HelperService;
import ru.main.services.SceneSwitchService;

public class TypesController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCreate;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonSwitchSceneCategories;

    @FXML
    private Button buttonSwitchSceneDisks;

    @FXML
    private Button buttonSwitchSceneTypes;

    @FXML
    private Button buttonUpdate;

    @FXML
    private TableColumn<TypesModel, Integer> tableColumnId;

    @FXML
    private TableColumn<TypesModel, String> tableColumnType;

    @FXML
    private TableView<TypesModel> tableView;

    @FXML
    private TextArea textAreaType;
    @FXML
    private TextField textFieldId;

    @FXML
    void buttonCreate(ActionEvent event) throws SQLException {
        if (textAreaType.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "Типы носителей",
                    "Произошла ошибка при добавлении данных.",
                    "Проверьте правильность введенных данных и повторите попытку.");
        } else {
            createType();
        }
    }

    @FXML
    void buttonDelete(ActionEvent event) throws SQLException {
        if (textFieldId.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "Типы носителей",
                    "Произошла ошибка при удалении данных.",
                    "Проверьте корректность выполнения операции и повторите попытку.");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Типы носителей");
            alert.setHeaderText("Подтвердите удаление данных.");
            alert.setContentText("Вы уверены, что хотите удалить данные?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                deleteType();
            }
        }
    }

    @FXML
    void tableViewMouseClicked(MouseEvent event) {
        TypesModel typesModel = tableView.getSelectionModel().getSelectedItem();
        textAreaType.setText(typesModel.getTitle());
        textFieldId.setText(typesModel.getId().toString());
    }

    @FXML
    void buttonSwitchSceneDisks(ActionEvent event) throws IOException {
        SceneSwitchService sceneSwitchService = new SceneSwitchService();
        sceneSwitchService.switchScene("/ru/main/disks-view.fxml", event, "ManagerCompactDisk");
    }

    @FXML
    void buttonSwitchSceneCategories(ActionEvent event) throws IOException {
        SceneSwitchService sceneSwitchService = new SceneSwitchService();
        sceneSwitchService.switchScene("/ru/main/categories-view.fxml", event, "Категории информации");
    }

    @FXML
    void buttonUpdate(ActionEvent event) throws SQLException {
        if (textAreaType.getText().isEmpty() || textFieldId.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "Типы носителей",
                    "Произошла ошибка при обновлени данных.",
                    "Проверьте правильность введенных данных и повторите попытку.");
        } else {
            updateType();
        }
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setTypes();
    }
    private void createType() throws SQLException {
        String sql = "INSERT INTO " + DatabaseConfig.getPrefix() + "types (title) VALUES ('" + textAreaType.getText() + "')";
        DatabaseService.executeQuery(sql);
        setTypes();
        clearFields();
    }

    private void updateType() throws SQLException {
        String sql = "UPDATE " + DatabaseConfig.getPrefix() + "types SET title = '" + textAreaType.getText() + "' WHERE id = " + textFieldId.getText() + "";
        DatabaseService.executeQuery(sql);
        setTypes();
        clearFields();
    }
    private void deleteType() throws SQLException {
        String sql = "DELETE FROM " + DatabaseConfig.getPrefix() + "types WHERE id = " + textFieldId.getText() + "";
        DatabaseService.executeQuery(sql);
        setTypes();
        clearFields();
    }
    private void setTypes() {
        ObservableList<TypesModel> typesModelObservableList = TypesModel.getTypes();

        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableView.setItems(typesModelObservableList);
    }
    private void clearFields() {
        textAreaType.clear();
        textFieldId.clear();
    }
}
