package com.company;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Point{
    private String x;
    private String y;

    Point(){
        this.x = "0";
        this.y = "0";
    }

    Point(String x, String y){
        this.x = x;
        this.y = y;
    }

    public void setx(String x){
        this.x = x;
    }

    public void sety(String y){
        this.y = y;
    }

    public String getx(){
        return this.x;
    }

    public String gety(){
        return this.y;
    }

    public String toString(){
        System.out.println("("+this.x + ", " + this.y+")");
        return null;
    }

    public double distO() {
        double x = parseInt(this.x);
        double y = parseInt(this.y);
        return Math.sqrt((x*x)+(y*y));

    }
    public double distP(Point p2) {
        double x = parseInt(p2.x)- parseInt(this.x);
        double y = parseInt(p2.y)- parseInt(this.y);
        return Math.sqrt((x*x)+(y*y));
    }

}

class JTime {
    private int hr;
    int min;
    int sec;

    public void setHr(int hr) {
        hr = hr;
    }

    public void setMin(int h) {
        min = h;
    }

    public void setSec(int Sec) {
        sec = Sec;
    }

    public String toString() {
        return "(" + hr + ":" + min + ":" + sec + ")";
    }

    public JTime() {
        hr = min = sec = 0;
    }

    public JTime(int H, int M, int S) {
        hr = H;
        min = M;
        sec = S;
    }

    public JTime(String t) {
        String[] ar = t.split(":");
        if (ar.length == 3) {
            int h = Integer.parseInt(ar[0]);
            int m = Integer.parseInt(ar[1]);
            int s = Integer.parseInt(ar[2]);

            if (h <= 12 && m < 60 && s < 60) {
                hr = h;
                min = m;
                sec = s;
            }
        } else {
            hr = 0;
        }
        min = 0;
        sec = 0;
    }

    JTime(int scnd){
        this();
            min = (scnd/60) % 60;
            hr = sec/360;
            sec = scnd % 60;
    }

    public static void main(String[] args) {
        JTime t1 = new JTime();
        JTime t2 = new JTime(3, 5, 66);
        JTime t3 = new JTime("12:3:34");
        JTime t4 = t2;

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);

        t4.setMin(7);
        System.out.println(t2);
        System.out.println(t4);

        JTime []timeArr=new JTime[10];
        for(int i=0;i<timeArr.length;i++)
        {
            timeArr[i]=new JTime(0,i,i+2);
        }
        System.out.println(">>"+ timeArr[0].min);
    }

    public int timeInSec(JTime t1, JTime t2){
        int sec1 = (t1.hr*360) + (t1.min*60) + (t1.sec);
        int sec2 = (t2.hr*360) + (t2.min*60) + (t2.sec);
        return Math.abs(sec1-sec2);
    }

    public JTime timeInStamp(JTime t1, JTime t2){
        int sec1 = (t1.hr*360) + (t1.min*60) + (t1.sec);
        int sec2 = (t2.hr*360) + (t2.min*60) + (t2.sec);
        int scnd = Math.abs(sec1-sec2);
        int min = (scnd/60) % 60;
        int hr = sec/360;
        int sec = scnd % 60;
        return new JTime(hr, min, sec);
    }

}

class Pixel{
    int r;
    int g;
    int b;

    public Pixel(){
        this.r = this.g = this.b = 0;
    }

    public Pixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void convertToGrey(){
        double grey = ((double)this.r/3) + ((double)this.g/3) + ((double)this.b/3);
    }
    public void convertToWeightedGrey(){
        double grey = (this.r*0.299) + (this.g*0.587) + (this.b*0.114);
    }
}

