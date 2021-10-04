import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class labOne{
    public static void main(String[] args){

    }

//TASK 1

    public static void sliceArray(int[] inarray, int start, int end, int step){

        if(((start < end) && (end < inarray.length))||((start > end) && (start < inarray.length))){
            System.out.print("{");
            if(start<end){
                for(int i = start; i < end; i+=step){
                    System.out.print(inarray[i] + ", ");
                }
                System.out.print("}");
            }
            else{
                for(int i = start; i > end; i-=step){
                    System.out.print(inarray[i] + ", ");
                }
                System.out.print("}");
            }
        }
        else {
            System.out.println("Index out of bound");
        }
    }
    public static void slice(int[] inArray){
        Scanner start = new Scanner(System.in);
        int startInt = start.nextInt();
        Scanner end = new Scanner(System.in);
        int endInt = end.nextInt();
        Scanner step = new Scanner(System.in);
        int stepInt = step.nextInt();
        sliceArray(inArray, startInt, endInt, stepInt);
    }

// TASK 2

    public static int billing(int units){
        if(units > 200){
            return 1200+((units-200)*15);
        }
        else if(units > 100){
            return 500 + ((units - 100) * 7);
        }
        else{
            return units * 5;
        }
    }

//TASK 3

    public static void numOfTimes(float num){
        if(num<0){
            System.out.println("Illegal input");
        }
        else {
            int i = 1;
            while(num > 1){
                num /= 2;
                i++;
            }
            System.out.println(i + " times");
        }
    }

//TASK 4

    public static void reverseOfNum(int num){
        int result = 0;
        while(num > 0){
            result*=10;
            result += (num%10);
            num/=10;
        }
        System.out.println(result);
    }

//TASK 5

    public static void displayTime(int mins){
        int hours = (mins/60);
        int remMins = mins - (hours*60);
        hours = hours%12;
        boolean flag = amOrPm(hours);
        if(hours==0){
            hours=12;
        }
        if(flag){
            System.out.println(hours+":"+remMins+" PM");
        }
        else{
            System.out.println(hours+":"+remMins+" AM");
        }
    }
    public static boolean amOrPm(int hours){
        int count = 0;
        while(hours>=12){
            hours-=12;
            count++;
        }
        return (count % 2) == 0;

    }

//TASK 6

    public static int numOfMonths(double salary, double portionSaved, double cost){
        double down = cost/4;
        double currentSaving = 0;
        double r = 0.04;
        int months = 0;
        while(currentSaving < down){
            double interest = currentSaving*(r/12);
            currentSaving += interest;
            double monthlySave = salary * portionSaved;
            currentSaving += monthlySave;
            months += 1;
        }
        return months;
    }

    public static void numOfMonthsRun(){
        System.out.print("Enter Salary: ");
        Scanner salary = new Scanner(System.in);
        double salaryInput = salary.nextDouble();
        System.out.print("Enter Portion to Save: ");
        Scanner portion = new Scanner(System.in);
        double portionSaved = portion.nextDouble();
        System.out.print("Enter Cost of your Dream House: ");
        Scanner cost = new Scanner(System.in);
        double costInput = cost.nextDouble();
        System.out.println("Num of Months: " + numOfMonths2(salaryInput, portionSaved, costInput));
    }

// TASK 7

    public static int numOfMonths2(double salary, double portionSaved, double cost){
        double down = cost/4;
        double currentSaving = 0;
        double r = 0.04;
        int months = 0;
        while(currentSaving < down){
            double monthlySave = salary * portionSaved;
            currentSaving += monthlySave;
            months += 1;
            if(months%12==0){
                currentSaving+= (currentSaving+.04);
            }
        }
        return months;
    }
}