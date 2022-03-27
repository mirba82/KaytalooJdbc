package org.example.model;

import org.example.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableCountry {

    public static void createTableCountry() {
        String Create_SQl = "create table if not exists Countries(" +
                "id serial primary key," +
                "name varchar(250)," +
                "population int," +
                "cityId int references Cities(id));";
        try (Connection connection = Database.connection()) {
            Statement stm = connection.createStatement();
            stm.executeUpdate(Create_SQl);
            stm.close();
            System.out.println("Country table successfully created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveCountries(String name, int population, int cityId) {

        String Save_SQL = "insert into Countries(name, population, cityId) values(?,?,?);";
                    try(Connection conn = Database.connection()){
                        PreparedStatement prstm = conn.prepareStatement(Save_SQL);
                        prstm.setString(1,name);
                        prstm.setInt(2,population);
                        prstm.setInt(3,cityId);
                        prstm.executeUpdate();
                        prstm.close();
                        System.out.println("Country values successfully add "+ name);

                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
    }
    public static List<Country>getAllCountries(){
        String Get_All_Countries = "select * from countries";
        List<Country>countryList = new ArrayList<>();
        try (Connection conn = Database.connection()){
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(Get_All_Countries);
            System.out.println("Country table is an ArrayList");
            while (resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getLong("id"));
                country.setName(resultSet.getString("name"));
                country.setPopulation(resultSet.getInt("population"));
                country.setCityId(resultSet.getInt("cityId"));
                countryList.add(country);
                System.out.println(country);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return countryList;
    }
}


