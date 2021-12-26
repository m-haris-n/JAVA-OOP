package com.company;

public class HourlyWorker extends Employee{
    int hoursWorked;
    int hourlyRate;

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public HourlyWorker(String firstName, String surName, int age, int hoursWorked, int hourlyRate) {
        super(firstName, surName, age);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    void calcPay(){
        System.out.println("calculating hourly worker pay:");
        this.ypay = this.hourlyRate*this.hoursWorked*52;
        System.out.println(this.ypay);
    }
}
