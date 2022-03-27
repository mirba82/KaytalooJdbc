package org.example.model;

import org.example.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableMayor {

    public static void createTableMayor() {
        String createSQL = "create table if not exists Mayors (" +
                "id serial primary key," +
                "name text," +
                "age int," +
                "cityId int references Cities(id));";
        System.out.println("Table Mayors successfully created!");
        try (Connection connection = Database.connection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveMayors(String name, int age, int cityId) {
        String saveSQL = "insert into Mayors(name, age, cityId) values(?, ?, ?);";
        try (Connection connection = Database.connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, cityId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Added in table Mayors success: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<Mayor> getAllMayors() {
        String Get_All_Mayors = "select * from mayors";
        List<Mayor> mayorList = new ArrayList<>();
        try (Connection connection = Database.connection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Get_All_Mayors);
            while (resultSet.next()) {
                Mayor mayor = new Mayor();
                mayor.setId(resultSet.getLong("id"));
                mayor.setName(resultSet.getString("name"));
                mayor.setAge(resultSet.getInt("age"));
                mayor.setCityId(resultSet.getInt("cityId"));
                mayorList.add(mayor);
                System.out.println(mayor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mayorList;
    }
}

