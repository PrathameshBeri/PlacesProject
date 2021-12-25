package com.beri;

public class Place {

    private String name;
    private String country;

    public Place(){

    }
    public Place(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
