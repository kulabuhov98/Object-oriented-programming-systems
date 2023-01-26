package ru.main.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.main.configs.DatabaseConfig;
import ru.main.services.GetConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriesModel  {
    Integer id;
    String title;

    public CategoriesModel(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public static ObservableList<CategoriesModel> getCategories() {
        ObservableList<CategoriesModel> categoriesModelObservableList = FXCollections.observableArrayList();
        GetConnectionService getConnectionService = new GetConnectionService();
        Connection connection = getConnectionService.getConnection();

        String sql = "SELECT id, title FROM " + DatabaseConfig.getPrefix() + "categories";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");

                categoriesModelObservableList.add(new CategoriesModel(id, title));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return categoriesModelObservableList;
    }
}
