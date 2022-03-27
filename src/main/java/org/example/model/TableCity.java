package org.example.model;

import org.example.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableCity {
    public static void createTable() {
        String Create_SQL = "create table if not exists Cities(" +
                "ID SERIAL PRIMARY KEY," +
                "city_name VARCHAR(255)," +
                "city_age INTEGER NOT NULL," +
                "mayorId int );";

        System.out.println("Table Cities successfully created!");
        try (Connection connection = Database.connection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Create_SQL);

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        public static void saveCities(String city_name, int city_age,int mayorId) {
            String Save_SQL = "insert into Cities(city_name,city_age, mayorId) values(?,?, ?);";
            try (Connection connection = Database.connection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(Save_SQL);
                preparedStatement.setString(1, city_name);
                preparedStatement.setInt(2, city_age);
                preparedStatement.setInt(3, mayorId);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println("Added in table Cities success: " + city_name);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public static List<City> getAllCities() {
            System.out.println("Output all cityTable");
            String Get_All_City_SQL = "select * from cities";
            List<City> cityList = new ArrayList<>();
            try
                    (Connection connection = Database.connection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(Get_All_City_SQL)) {
                while (resultSet.next()) {
                    City city = new City();
                    city.setId(resultSet.getLong("id"));
                    city.setCity_name(resultSet.getString("city_name"));
                    city.setCity_age(resultSet.getInt("city_age"));
                    city.setMayorId(resultSet.getInt("mayorId"));

                    cityList.add(city);
                    System.out.println(cityList);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return cityList;
        }
    }
