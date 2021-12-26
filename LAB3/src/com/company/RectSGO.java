package com.company;

public class RectSGO extends SGO {
    double length;
    double width;


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWidthLength(double width, double length){
        this.width = width;
        this.length = length;
    }

    public RectSGO(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public RectSGO(String color){
        setColor(color);
    }

    @Override
//    public String toString() {
//        return "RectSGO{" +
//                "length=" + length +
//                ", width=" + width +
//                '}';
//    }

    @Override
    public void drawShape(){

    }
}
