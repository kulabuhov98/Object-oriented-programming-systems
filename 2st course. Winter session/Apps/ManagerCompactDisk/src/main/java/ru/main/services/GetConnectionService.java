package ru.main.services;

import java.sql.Connection;
import java.sql.DriverManager;

import ru.main.configs.DatabaseConfig;
public class GetConnectionService extends DatabaseConfig {
    public Connection connection;

    public Connection getConnection() {
        String connectionString = "jdbc:mysql://" + host + "/" + database;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, login, password);
            return connection;
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            return null;
        }
    }

}
