package ru.main.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.main.configs.DatabaseConfig;
import ru.main.services.GetConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisksModel {
    Integer idDisk, idType, idCategory;
    String type, category, description;

    public DisksModel(Integer idDisk, Integer idType, Integer idCategory, String type, String category, String description) {
        this.idDisk = idDisk;
        this.idType = idType;
        this.idCategory = idCategory;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    public Integer getIdDisk() {
        return idDisk;
    }

    public void setIdDisk(Integer idDisk) {
        this.idDisk = idDisk;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ObservableList<DisksModel> getDisks() {
        ObservableList<DisksModel> disksModelObservableList = FXCollections.observableArrayList();
        GetConnectionService getConnectionService = new GetConnectionService();
        Connection connection = getConnectionService.getConnection();

        /*String sql = "SELECT " + DatabaseConfig.getPrefix() + "types.title AS type, " + DatabaseConfig.getPrefix() + "categories.title AS " +
                "category, " + DatabaseConfig.getPrefix() + "disks.id AS idDisk, " + DatabaseConfig.getPrefix() + "disks.description AS description " +
                "FROM " + DatabaseConfig.getPrefix() + "disks INNER JOIN " + DatabaseConfig.getPrefix() + "types ON " + DatabaseConfig.getPrefix() + "types.id = "
                + DatabaseConfig.getPrefix() + "disks.idType INNER JOIN "  + DatabaseConfig.getPrefix() + "categories ON " + DatabaseConfig.getPrefix() +
                "categories.id = " + DatabaseConfig.getPrefix() + "disks.idCategories";*/

        String sql = "SELECT " + DatabaseConfig.getPrefix() + "types.title AS type, KU_types.id AS idType, " + DatabaseConfig.getPrefix() + "categories.title AS " +
                "category, KU_categories.id AS idCategory, " + DatabaseConfig.getPrefix() + "disks.id AS idDisk, " + DatabaseConfig.getPrefix() + "disks.description AS description " +
                "FROM " + DatabaseConfig.getPrefix() + "disks INNER JOIN " + DatabaseConfig.getPrefix() + "types ON " + DatabaseConfig.getPrefix() + "types.id = "
                + DatabaseConfig.getPrefix() + "disks.idType INNER JOIN "  + DatabaseConfig.getPrefix() + "categories ON " + DatabaseConfig.getPrefix() +
                "categories.id = " + DatabaseConfig.getPrefix() + "disks.idCategories";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer idDisk = resultSet.getInt("idDisk");
                Integer idType = resultSet.getInt("idType");
                Integer idCategory = resultSet.getInt("idCategory");
                String type = resultSet.getString("type");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");

                disksModelObservableList.add(new DisksModel(idDisk, idType, idCategory, type, category, description));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return disksModelObservableList;
    }
}
