package com.company;

public class Pixel {
    Pos p;
    Color c;

    public Pos getP() {
        return p;
    }

    public void setP(Pos p) {
        this.p = p;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Pixel(Pos p, Color c) {
        this.p = p;
        this.c = c;
    }

    public Pixel(int x, int y, Color c){
        this.p = new Pos(x, y);
        this.c = c;
    }

    public Pixel(int x, int y, String hex){
        this.p = new Pos(x, y);
        this.c = new Color(hex);
    }

    @Override
    public String toString() {
        return "Pixel{" +
                "Position=" + p +
                ", Color=" + c.getColorHEX() +
                '}';
    }

    public void convertGrey(){
        int grey = (this.c.getR()+this.c.getG()+this.c.getB())/3;
        this.c.setR(grey);
        this.c.setG(grey);
        this.c.setB(grey);
    }



    public static void main(String[] args) {
        Color c1 = new Color("1f4affaf");
        Color c2 = new Color();
        Color c3 = new Color(12,24,453,243);
        Pixel p1= new Pixel(3,4,c1);
        System.out.println(">> "+p1);
        p1.convertGrey();
        System.out.println(">> "+p1);
        Pixel p2 = new Pixel(4,3, c3);
        System.out.println(">> "+p2);


    }
}
