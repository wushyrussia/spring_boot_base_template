package com.example.template.DTO;

public class PersonInnerDTO {
    private String name;
    private String age;
    private String logo;
    private String password;
    private String cardNumber;

    public PersonInnerDTO(String name, String age, String logo, String password, String cardNumber) {
        this.name = name;
        this.age = age;
        this.logo = logo;
        this.password = password;
        this.cardNumber = cardNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
