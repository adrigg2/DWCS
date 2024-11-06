package com.adrian;

// Base class for a generic person
public class Person {
    private int id;
    private int birthYear;
    private String name;

    public Person(int id, int birthYear, String name) {
        this.id = id;
        this.birthYear = birthYear;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getBirthYear() {
        return birthYear;
    }    

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", birth year: " + birthYear;
    }
}
