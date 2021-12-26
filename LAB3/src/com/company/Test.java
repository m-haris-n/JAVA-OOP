package com.company;

public class Test {
    public static void main(String[] args) {
        CircleSGO c1 = new CircleSGO(2, "blue");
        System.out.println("Color of Circle:"+c1.getColor());
        RectSGO r1 = new RectSGO("brown");
        System.out.println("Color of Rect:" + r1.getColor());
        r1.setColor("black");
        System.out.println("Color of rect now:" + r1.getColor());
        System.out.println(r1);
        System.out.println(c1);
    }
}
