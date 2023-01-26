package ru.main.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.main.models.CategoriesModel;
import ru.main.services.DatabaseService;
import ru.main.services.GetConnectionService;
import ru.main.services.HelperService;
import ru.main.services.SceneSwitchService;
import ru.main.configs.DatabaseConfig;
public class CategoriesController implements Initializable {

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
    private TableColumn<CategoriesModel, String> tableColumnCategory;

    @FXML
    private TableColumn<CategoriesModel, Integer> tableColumnId;

    @FXML
    private TableView<CategoriesModel> tableView;

    @FXML
    private TextArea textAreaCategory;
    @FXML
    private TextField textFieldId;

    @FXML
    /**
     * Добавление категории в базу данных с помощью метода createCategory.
     * Выполняется проверка на корректность заполнение поля.
     */
    void buttonCreate(ActionEvent event) throws SQLException {
        if (textAreaCategory.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "Категории информации",
                    "Произошла ошибка при добавлении данных.",
                    "Проверьте правильность введенных данных и повторите попытку.");
        } else {
            createCategory();
        }
    }

    @FXML
    /**
     * Удаление категории из базы данных с помощью метода deleteCategory.
     * Перед удалением информации, действие необходимо подтвердить
     */
    void buttonDelete(ActionEvent event) throws SQLException {
        if (textFieldId.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "Категории информации",
                    "Произошла ошибка при удалении данных.",
                    "Проверьте корректность выполнения операции и повторите попытку.");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Категории информации");
            alert.setHeaderText("Подтвердите удаление данных.");
            alert.setContentText("Вы уверены, что хотите удалить данные?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                deleteCategory();
            }
        }
    }

    @FXML
    /**
     * Используем метод swtichScene для перехода между окнами приложения
     */
    void buttonSwitchSceneDisks(ActionEvent event) throws IOException {
        SceneSwitchService sceneSwitchService = new SceneSwitchService();
        sceneSwitchService.switchScene("/ru/main/disks-view.fxml", event, "ManagerCompactDisk");
    }

    @FXML
    /**
     * Используем метод swtichScene для перехода между окнами приложения
     */
    void buttonSwitchSceneTypes(ActionEvent event) throws IOException {
        SceneSwitchService sceneSwitchService = new SceneSwitchService();
        sceneSwitchService.switchScene("/ru/main/types-view.fxml", event, "Типы носителей");
    }

    @FXML
    /**
     * Обновление категории в базу данных с помощью метода updateCategory.
     * Выполняется проверка на корректность заполнение поля.
     */
    void buttonUpdate(ActionEvent event) throws SQLException {
        if (textAreaCategory.getText().isEmpty() || textFieldId.getText().isEmpty()) {
            HelperService.dialogs(Alert.AlertType.ERROR, "Категории информации",
                    "Произошла ошибка при обновлении данных.",
                    "Проверьте правильность введенных данных и повторите попытку.");
        } else {
            updateCategory();
        }
    }

    @FXML
    /**
     * Получение данных выделенной строки из таблицы, затем отображение их в полях для ввода
     */
    void tableViewMouseClicked(MouseEvent event) {
        CategoriesModel categoriesModel = tableView.getSelectionModel().getSelectedItem();
        textAreaCategory.setText(categoriesModel.getTitle());
        textFieldId.setText(categoriesModel.getId().toString());
    }

    @Override
    /**
     * Отображение данных в таблице при инициализации окна
     */
    public void initialize(URL location, ResourceBundle resources) {
        setCategories();
    }
    private void setCategories() {
        ObservableList<CategoriesModel> categoriesModelObservableList = CategoriesModel.getCategories();

        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnCategory.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableView.setItems(categoriesModelObservableList);
    }
    private void createCategory() throws SQLException {
        String sql = "INSERT INTO " + DatabaseConfig.getPrefix() + "categories (title) VALUES ('" + textAreaCategory.getText() + "')";
        DatabaseService.executeQuery(sql);
        setCategories();
        clearFields();
    }

    private void updateCategory() throws SQLException {
        String sql = "UPDATE " + DatabaseConfig.getPrefix() + "categories SET title = '" + textAreaCategory.getText() + "' WHERE id = " + textFieldId.getText() + "";
        DatabaseService.executeQuery(sql);
        setCategories();
        clearFields();
    }

    private void deleteCategory() throws SQLException {
        String sql = "DELETE FROM " + DatabaseConfig.getPrefix() + "categories WHERE id = " + textFieldId.getText() + "";
        DatabaseService.executeQuery(sql);
        setCategories();
        clearFields();
    }

    private void clearFields() {
        textAreaCategory.clear();
        textFieldId.clear();
    }
}
