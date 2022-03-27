package org.example.model;

public class Country {
    private Long id;
    private String name;
    private int population;
    private int cityId;

    public Country() {
    }

    public Country(Long id, String name, int population, int cityId) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", cityId=" + cityId +
                '}';
    }
}
