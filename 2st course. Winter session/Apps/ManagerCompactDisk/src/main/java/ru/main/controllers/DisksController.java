package ru.main.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import ru.main.models.CategoriesModel;
import ru.main.models.DisksModel;
import ru.main.models.TypesModel;
import ru.main.services.DatabaseService;
import ru.main.services.HelperService;
import ru.main.services.SceneSwitchService;

public class DisksController implements Initializable {

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
    private TableColumn<CategoriesModel, String> tableCategoriesColumnCategory;

    @FXML
    private TableColumn<CategoriesModel, Integer> tableCategoriesColumnId;

    @FXML
    private TableColumn<DisksModel, String> tableDisksColumnCategory;

    @FXML
    private TableColumn<DisksModel, String> tableDisksColumnDescription;

    @FXML
    private TableColumn<DisksModel, Integer> tableDisksColumnId;

    @FXML
    private TableColumn<DisksModel, String> tableDisksColumnType;

    @FXML
    private TableColumn<TypesModel, Integer> tableTypesColumnId;

    @FXML
    private TableColumn<TypesModel, String> tableTypesColumnType;

    @FXML
    private TableView<CategoriesModel> tableViewCategories;

    @FXML
    private TableView<DisksModel> tableViewDisks;

    @FXML
    private TableView<TypesModel> tableViewTypes;

    @FXML
    private TextArea textAreaDescription;

    @FXML
    private TextField textFieldCategory;

    @FXML
    private TextField textFieldIdCategory;

    @FXML
    private TextField textFieldIdDisk;

    @FXML
    private TextField textFieldIdType;

    @FXML
    private TextField textFieldType;

    @FXML
    void buttonCreate(ActionEvent event) throws SQLException {
        if (textAreaDescription.getText().isEmpty() || textFieldCategory.getText().isEmpty() ||
                textFieldIdCategory.getText().isEmpty() || textFieldIdType.getText().isEmpty() ||
                textFieldType.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "ManagerCompactDisk",
                    "Произошла ошибка при добавлении данных.",
                    "Проверьте правильность введенных данных и повторите попытку.");
        } else {
            createDisk();
        }
    }

    @FXML
    void buttonDelete(ActionEvent event) throws SQLException {
        if (textFieldIdDisk.getText().isEmpty() == true) {
            HelperService.dialogs(Alert.AlertType.ERROR, "ManagerCompactDisk",
                    "Произошла ошибка при удалении данных.",
                    "Проверьте корректность выполнения операции и повторите попытку.");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ManagerCompactDisk");
            alert.setHeaderText("Подтвердите удаление данных.");
            alert.setContentText("Вы уверены, что хотите удалить данные?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                deleteDisk();
            }
        }
    }

    @FXML
    void buttonSwitchSceneCategories(ActionEvent event) throws IOException {
        SceneSwitchService sceneSwitchService = new SceneSwitchService();
        sceneSwitchService.switchScene("/ru/main/categories-view.fxml", event, "Категории информации");
    }

    @FXML
    void buttonSwitchSceneTypes(ActionEvent event) throws IOException {
        SceneSwitchService sceneSwitchService = new SceneSwitchService();
        sceneSwitchService.switchScene("/ru/main/types-view.fxml", event, "Типы носителей");
    }

    @FXML
    void buttonUpdate(ActionEvent event) throws SQLException {
        if (textAreaDescription.getText().isEmpty() || textFieldCategory.getText().isEmpty() ||
                textFieldIdCategory.getText().isEmpty() || textFieldIdType.getText().isEmpty() ||
                textFieldType.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "ManagerCompactDisk",
                    "Произошла ошибка при обновлении данных.",
                    "Проверьте правильность введенных данных и повторите попытку.");
        } else {
            updateDisk();
        }
    }

    @FXML
    void tableViewCategoriesMouseClicked(MouseEvent event) {
        CategoriesModel categoriesModel = tableViewCategories.getSelectionModel().getSelectedItem();

        textFieldIdCategory.setText(categoriesModel.getId().toString());
        textFieldCategory.setText(categoriesModel.getTitle());
    }

    @FXML
    void tableViewDisksMouseClicked(MouseEvent event) {
        DisksModel disksModel = tableViewDisks.getSelectionModel().getSelectedItem();

        textFieldIdDisk.setText(disksModel.getIdDisk().toString());
        textFieldType.setText(disksModel.getType());
        textFieldCategory.setText(disksModel.getCategory());
        textAreaDescription.setText(disksModel.getDescription());

        textFieldIdType.setText(disksModel.getIdType().toString());
        textFieldIdCategory.setText(disksModel.getIdCategory().toString());
    }

    @FXML
    void tableViewTypesMouseClicked(MouseEvent event) {
        TypesModel typesModel = tableViewTypes.getSelectionModel().getSelectedItem();

        textFieldIdType.setText(typesModel.getId().toString());
        textFieldType.setText(typesModel.getTitle());
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setDisks();
    }

    private void setDisks() {
        ObservableList<DisksModel> disksModelObservableList = DisksModel.getDisks();
        ObservableList<TypesModel> typesModelObservableList = TypesModel.getTypes();
        ObservableList<CategoriesModel> categoriesModelObservableList = CategoriesModel.getCategories();

        tableDisksColumnId.setCellValueFactory(new PropertyValueFactory<>("idDisk"));
        tableDisksColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableDisksColumnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableDisksColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        tableCategoriesColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableCategoriesColumnCategory.setCellValueFactory(new PropertyValueFactory<>("title"));

        tableTypesColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableTypesColumnType.setCellValueFactory(new PropertyValueFactory<>("title"));

        tableViewDisks.setItems(disksModelObservableList);
        tableViewTypes.setItems(typesModelObservableList);
        tableViewCategories.setItems(categoriesModelObservableList);
    }

    private void createDisk() throws SQLException {
        String sql = "INSERT INTO " + DatabaseConfig.getPrefix() + "disks (idType, idCategories, description) VALUES " +
                "(" + textFieldIdType.getText() + "," + textFieldIdCategory.getText() + ",'" + textAreaDescription.getText() +"')";
        DatabaseService.executeQuery(sql);
        setDisks();
        clearFields();
    }
    private void deleteDisk() throws SQLException {
        String sql = "DELETE FROM " + DatabaseConfig.getPrefix() + "disks WHERE id = " + textFieldIdDisk.getText() + "";
        DatabaseService.executeQuery(sql);
        setDisks();
        clearFields();
    }

    private void updateDisk() throws SQLException {
        String sql = "UPDATE " + DatabaseConfig.getPrefix() + "disks SET idType = " + textFieldIdType.getText() + ", idCategories = "
                + textFieldIdCategory.getText() + ", description = '" + textAreaDescription.getText() + "' WHERE id = " + textFieldIdDisk.getText() + "";
        DatabaseService.executeQuery(sql);
        setDisks();
        clearFields();
    }
    private void clearFields() {
        textFieldIdDisk.clear();
        textFieldIdType.clear();
        textFieldIdCategory.clear();
        textFieldType.clear();
        textFieldCategory.clear();
        textAreaDescription.clear();
    }
}
