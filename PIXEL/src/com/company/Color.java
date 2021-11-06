package com.company;

public class Color{
    private int r;
    private int g;
    private int b;
    private int alpha;
    private final int limit = 255;

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

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return "Color{" +
                "R=" + r +
                ", G=" + g +
                ", B=" + b +
                ", Aplha=" + alpha +
                '}';
    }

    public Color(){
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.alpha = 255;
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = 255;
        if(this.r > limit){
            this.r = limit;
        }
        if(this.g > limit){
            this.g = limit;
        }
        if(this.b > limit){
            this.b = limit;
        }

    }

    public Color(int r, int g, int b, int alpha) {
        this(r, g, b);
        if(this.alpha > 255){
            this.b = 255;
        }
    }

    

    public String getColorHEX(){
        return String.format("%02x", r) + String.format("%02x", g) + String.format("%02x", b) +String.format("%2x", alpha);
    }

    public static void main(String[] args) {
        Color c1 = new Color("1f4affaf");
        Color c2 = new Color();
        Color c3 = new Color(12,24,453,243);
        System.out.println(c1);
        System.out.println(c1.getColorHEX());
        System.out.println(c2);
        System.out.println(c2.getColorHEX());
        System.out.println(c3);
        System.out.println(c3.getColorHEX());
    }
}
