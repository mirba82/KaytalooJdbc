package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String user = "postgres";
    private static final String password = "mirba85";

    public static Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DataBase successfully connected");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

