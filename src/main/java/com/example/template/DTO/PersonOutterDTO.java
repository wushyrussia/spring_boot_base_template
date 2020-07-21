package com.example.template.DTO;

public class PersonOutterDTO {
    String name;
    String age;
    String logo;

    public PersonOutterDTO(String name, String age, String logo) {
        this.name = name;
        this.age = age;
        this.logo = logo;
    }

    public PersonOutterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

