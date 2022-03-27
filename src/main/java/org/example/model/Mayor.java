package org.example.model;

public class Mayor {
    private Long id;
    private String name;
    private int age;
    private int cityId;

    public Mayor() {
    }

    public Mayor(Long id, String name, int age, int cityId) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                '}';
    }
}

