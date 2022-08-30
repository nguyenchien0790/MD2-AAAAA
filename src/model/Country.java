package model;

import java.io.Serializable;

public class Country implements Serializable, Comparable<Country> {
    private int id;
    private String name;

    public Country(String newCategoryName) {
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Country o) {
        return this.getName().compareTo(o.getName());
    }
}
