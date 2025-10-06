package com.example.demo_rest_controller.model;

public class Country {

    private String name;
    private int population; // in milioni di abitanti

    // metodo costruttore statico, factory method
    public static Country of(String name, int population) {
        Country country = new Country();
        country.name = name;
        country.population = population;
        return country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
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
}
