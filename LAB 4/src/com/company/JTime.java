package com.company;

import static java.lang.Integer.parseInt;



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
        if(scnd <60){
            sec = scnd;
        }else if(scnd<3600){
            min = scnd/60;
            sec = scnd % 60;
        }else{
            min = (scnd/60) % 60;
            hr = sec/3600;
            sec = scnd % 60;
        }
    }

    public static void main(String[] args) {
        JTime t1 = new JTime();
        JTime t2 = new JTime(3, 5, 59);
        JTime t3 = new JTime("4:5:59");
        JTime t4 = t2;

        System.out.println(t1.timeInSec(t2,t3));
        System.out.println(t2.timeInStamp(t2,t3));
//        System.out.println(t3);
//        System.out.println(t4);
//
//        t4.setMin(7);
//        System.out.println(t2);
//        System.out.println(t4);
//
//        JTime []timeArr=new JTime[10];
//        for(int i=0;i<timeArr.length;i++)
//        {
//            timeArr[i]=new JTime(0,i,i+2);
//        }
//        System.out.println(">>"+ timeArr[0].min);
    }

    public int timeInSec(JTime t1, JTime t2){
        int sec1 = (t1.hr*3600) + (t1.min*60) + (t1.sec);
        int sec2 = (t2.hr*3600) + (t2.min*60) + (t2.sec);
        return Math.abs(sec1-sec2);
    }

    public JTime timeInStamp(JTime t1, JTime t2){
        int sec1 = (t1.hr*3600) + (t1.min*60) + (t1.sec);
        int sec2 = (t2.hr*3600) + (t2.min*60) + (t2.sec);
        int scnd = Math.abs(sec1-sec2);
        return new JTime(scnd);
    }

}
