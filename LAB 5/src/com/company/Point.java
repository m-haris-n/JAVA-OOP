package com.company;

import static java.lang.Integer.parseInt;
public class Point {

    private int x; //class level decleration
    private int y;

    // private int[]xy= new int[2];


    public void sety(int yy) {
        this.y = yy;
        // xy[1]=yy;
    }

    public void setx(int x) {
        this.x = x;
        // xy[0]=x;
    }

    public void print() {
        String p = "[" + x + "," + x + "]";
        System.out.println(p);
    }

    public double distO() {
        double d = Math.sqrt(x * x + y * y);
        return d;
    }
    // fs2.distP(fs);
    public double distP(Point p2) {
        int xo = p2.x - x;
        int yo = p2.y - y;
        return Math.sqrt(xo * xo + yo * yo);

    }

    public int gety() {
        return y;
    }


    public int getx() {
        return y;
    }


    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int Y) {
        this.x=x;
        y=Y;
    }

    public Point(int x) {
        this.x=x;
        y=0;
    }

    public String toString() {
        String p = "[" + x + "," + y + "]";
        return p;
    }

    public static void main(String[] args) {
        System.out.println("First Object (5,6)");
        Point fs = new Point();
        fs.print();
        // fs.x=9;
        fs.setx(5);
        fs.sety(6);
        fs.print();


        System.out.println("Second Object (6,6) ");

        Point fs2 = new Point();
        fs2.setx(6);
        fs2.sety(6);
        // fs2.print();

        System.out.println(fs2);

        System.out.println("Distance");
        System.out.println(fs2.distO());


        System.out.println(fs2.distP(fs));

        System.out.println(fs.distP(fs2));

        Point fs3=new Point(7,8);
        System.out.println(">>>"+ fs3);
        System.out.println(fs);

    }

}
