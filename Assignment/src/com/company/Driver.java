package com.company;

import java.util.Locale;

public abstract class Driver{
    String name;
    int age;
    String country;
    transient CarCons team;
    String gender;
    String teamName;
    int score = 0;
    int numOfRaces = 0;
    int[] pos = new int[10];
    int startPos = 0;
    int winProb = 0;
    int currentPos = 0;
    public Driver(String name, int age, String country, String gender) {
        this.name = name.toUpperCase(Locale.ROOT);
        this.country = country.toUpperCase(Locale.ROOT);
        this.age = age;
        this.gender = gender.toUpperCase(Locale.ROOT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country.toUpperCase(Locale.ROOT);
    }

    public CarCons getTeam() {
        return team;
    }

    public void setTeam(CarCons team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase(Locale.ROOT);
    }

    abstract void incScore(int pts);
    abstract void incPos(int pos);
    abstract void raced();

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Age: " + age + '\n' +
                "Country: " + country + '\n' +
                "Team: " + team + '\n' +
                "Gender: " + gender + '\n';
    }
}
