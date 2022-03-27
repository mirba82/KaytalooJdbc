package org.example.model;

public class City {
    private Long id;
    private String city_name;
    private int city_age;
    private int mayorId;

    public City() {
    }

    public City( String city_name, int city_age, int mayorId) {
        this.city_name = city_name;
        this.city_age = city_age;
        this.mayorId = mayorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCity_age() {
        return city_age;
    }

    public void setCity_age(int city_age) {
        this.city_age = city_age;
    }

    public int getMayorId() {
        return mayorId;
    }

    public void setMayorId(int mayorId) {
        this.mayorId = mayorId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", city_age=" + city_age +
                ", mayorId=" + mayorId +
                '}';
    }
}
