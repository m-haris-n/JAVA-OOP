package com.company;

public class CircleSGO extends SGO{
    private double radius;
    public CircleSGO(double radius, String color){
        this.radius = radius;
        setColor(color);
    }

    @Override
    public String toString() {
        return "CircleSGO{" +
                "radius=" + this.radius +

                "color=" + this.getColor() +
                '}';
    }

    @Override
    public void drawShape(){

    }
}
