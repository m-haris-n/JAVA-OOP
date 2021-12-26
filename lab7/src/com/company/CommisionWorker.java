package com.company;

public class CommisionWorker extends Employee{
    int basePay;
    int itemsSold;
    int commRate;

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public int getCommRate() {
        return commRate;
    }

    public void setCommRate(int commRate) {
        this.commRate = commRate;
    }

    public CommisionWorker(String firstName, String surName, int age, int basePay, int itemsSold, int commRate) {
        super(firstName, surName, age);
        this.basePay = basePay;
        this.itemsSold = itemsSold;
        this.commRate = commRate;
    }
    @Override
    public void calcPay(){
        System.out.println("calculating commission worker yearly pay");
        this.ypay = basePay*12+(itemsSold*commRate);
        System.out.println(this.ypay);
    }

}
