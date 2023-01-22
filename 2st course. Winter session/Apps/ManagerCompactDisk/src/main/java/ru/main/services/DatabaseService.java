package ru.main.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {
    public static void executeQuery(String sql) throws SQLException {
        GetConnectionService getConnectionService = new GetConnectionService();
        Connection connection = getConnectionService.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connection.close();
    }
}
