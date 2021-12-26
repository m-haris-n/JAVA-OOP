package com.company;

public class WeeklyEmployee extends Employee{
    int weeklyWage;

    public int getWeeklyWage() {
        return weeklyWage;
    }

    public void setWeeklyWage(int weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public WeeklyEmployee(String firstName, String surName, int age, int weeklyWage) {
        super(firstName, surName, age);
        this.weeklyWage = weeklyWage;
    }

    @Override
    public void calcPay(){
        System.out.println("calculating pay of weekly employee");
        this.ypay = weeklyWage * 12;
        System.out.println(this.ypay);
    }
}
