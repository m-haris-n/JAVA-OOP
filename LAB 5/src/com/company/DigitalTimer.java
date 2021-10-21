package com.company;

public class DigitalTimer {
    private int min, hr;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }
    DigitalTimer(){
        this.hr = 0;
        this.min = 0;
    }
    DigitalTimer(int hr, int min){
        this();
        if(hr<24) this.hr = hr;
        if(min<60) this.min = min;
    }
    public String toString(){
        String s = this.hr+":"+this.min;
        return s;
    }
    public void tick(){
        if(this.min<59){
            this.min++;
        }
        else{
            this.hr++;
            this.min = 0;
        }
        if(hr==24){
            this.hr = 0;
        }
    }
    public void set(int hr, int min){
        if(hr<24)this.hr = hr;
        if(min<60)this.min = min;
    }


}