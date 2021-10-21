package com.company;


import java.util.Random;

public class Martian {
    private String name;
    private Point pos;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Martian.count = count;
    }
    private static int count = 0;

    public Martian() {
        count++;
        this.name = "M" + count;
        this.pos= new Point(0,0);
    }

    public Martian(String name) {
        this();
        this.name = name;
    }

    public Martian(String name, int pos_x, int pos_y) {
        this();
        this.name = name;
        //    this.pos.setX(pos_x);
        //  this.pos.setY(pos_y);
        this.pos= new Point(pos_x,pos_y);
    }

    public Martian(String name, Point pos) {
        count++;
        this.name = name;
        this.pos=new Point(pos.getx(),pos.gety());

    }

    private void setPos(int xinc, int yinc) {
        pos.setx(pos.getx()+xinc);
        pos.sety(pos.gety()+yinc);

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    public static void collision(Martian [] mars){
        int count = mars[0].count;
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                if(mars[i] == mars[j]){
                    if(i!=j){
                        System.out.println("Martian "+i+"collides with Martian "+j);
                    }
                }
            }
        }
    }
    public boolean nearMe(Martian m)
    {
        if(this.pos.distP(m.pos)<3)
            return true;
        else
            return false;
    }

    public void move() {
        Random r = new Random();
        int xpos = r.nextInt(200);
        int ypos = r.nextInt(200);
        setPos(xpos,ypos);
        if(pos.getx()>100){
            pos.setx((200-xpos));
        }
        if(pos.gety()>200){
            pos.sety((200-ypos));
        }
    }

    public String toString() {
        return ">> " + name + " Position "+pos;
    }



    public static void main(String[] args) {
        int ind = 1;
        int time = 10;
        System.out.println(">"+Martian.count);
        Martian martians[] = new Martian[time];

            martians[0] = new Martian();
        // martians[0].setCount(67);
        System.out.println("Total "+ martians[0].count);

        for (int j = 0; j < time; j++) {
            Random rand = new Random();
            boolean flag = rand.nextBoolean();
            if(flag){
                martians[ind] = new Martian();
                ind++;
            }
            for (int i = 0; i < martians[0].count; i++) {

                martians[i].move();
                System.out.print(martians[i]);
                collision(martians);
            }
            System.out.println("");
        }
    }
}