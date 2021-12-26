package com.company;

public class Employee {
    String firstName;
    String surName;

    int age;
    float ypay;

    void calcPay() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", ypay=" + ypay +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getYpay() {
        return ypay;
    }

    public void setYpay(float ypay) {
        this.ypay = ypay;
    }

    public Employee(String firstName, String surName, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }
}
