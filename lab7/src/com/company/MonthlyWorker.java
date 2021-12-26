package com.company;

public class MonthlyWorker extends Employee{
    int monthlyPay;

    public int getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(int monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public MonthlyWorker(String firstName, String surName, int age, int monthlyPay) {
        super(firstName, surName, age);
        this.monthlyPay = monthlyPay;
    }

    @Override
    void calcPay(){
        System.out.println("calculating monthly worker pay:");
        this.ypay = 12*this.monthlyPay;
        System.out.println(this.ypay);
    }
}
