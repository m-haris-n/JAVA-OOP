import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class labTwo{
    public static void main(String[] args){

    }

    public static double calcSaving(double salary, double percentage, double cost, double months){
        double current_save = 0;
        double month_save = salary * percentage;
        for(int i = 1; i <= months; i ++){
            current_save += (((0.04/12)*current_save) + month_save);
        }
        return current_save;
    }

    public static double numOfMonths3(double salary, double cost, int months){
        double down_pay = cost *.25;
        double start = 0;
        double end = 1;
        double mid = (start + end)/2;
        double curr_sav = calcSaving(salary, 1, down_pay, months);
        if((curr_sav) < (down_pay-100)){
            System.out.println("no");
            return 0;
        }
        while(true) {
            curr_sav = calcSaving(salary, mid, down_pay, months);
            System.out.println(mid);
            if(curr_sav > (down_pay - 100) && curr_sav <(down_pay + 100)) {
                return mid;
            }
            if(curr_sav > (down_pay + 100)){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            mid = (start + end) / 2;

        }
    }

    public static double WalkyTalky(int meters){
        Random rand = new Random();
        int xCoord = 0;
        int yCoord = 0;
        for(int i = 0; i < meters; i++){
            int dir = rand.nextInt(4);
            switch (dir) {
                case 0 -> yCoord += 1;
                case 1 -> xCoord += 1;
                case 2 -> yCoord -= 1;
                case 3 -> xCoord -= 1;
            }
        }
        return Math.sqrt((xCoord*xCoord)+(yCoord*yCoord));
    }
}

class Time{
    int seconds;
    int minutes;
    int hours;
    String meridian = null;

    String switchMeridian() {
        return "pm";
    }

    void increaseSecond(){ this.seconds++; }
    void increaseMinute(){
        this.minutes++;
    }
    void increaseHour(){
        this.hours++;
    }

}

class Book{
    int bookID;
    int pages;
    int price;

    void get(){
        Scanner getID = new Scanner(System.in);
        this.bookID = getID.nextInt();
        Scanner getPages = new Scanner(System.in);
        this.pages = getPages.nextInt();
        Scanner getPrice = new Scanner(System.in);
        this.price = getPrice.nextInt();

    }

    void show(){
        System.out.println(this.bookID + this.pages + this.price);
    }

    void set(int id, int pages, int price){
        this.bookID = id;
        this.pages = pages;
        this.price = price;
    }
}


class Point{
    double xCoord;
    double yCoord;
    double zCoord;

    double getX(){
        return this.xCoord;
    }
    double getY(){
        return this.yCoord;
    }
    double getZ(){
        return this.zCoord;
    }

    void getPoint(){
        System.out.println(xCoord+yCoord+zCoord);
    }


}