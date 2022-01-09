package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public LocalDate getDate(HashMap<LocalDate, String> history){
        LocalDate date = null;

        return date;
    }

    public static void main(String[] args) throws IOException {
        int select;
        F1CM f1CM = new F1CM();
        f1CM.posToPtsInit();
        f1CM.winProbInit();
        ArrayList<Object> allData = FileWriteAndRead.fileReader();
        f1CM.setDrivers((ArrayList<FormulaDriver>) allData.get(0));
        f1CM.setTeams((ArrayList<CarCons>) allData.get(1));
        f1CM.setRaceOrder(DateWriteAndRead.fileReader());
        System.out.println(f1CM.getRaceOrder());
        Set<LocalDate> allDates = f1CM.getRaceOrder().keySet();
        List<LocalDate> dateArr = new ArrayList<>(allDates);
        if(dateArr.size()!=0){
            LocalDate latest = dateArr.stream().max(LocalDate :: compareTo).get();
            f1CM.setDate(latest);
            f1CM.incDate(7);
        }
        else {
            LocalDate.of(2021, Month.JANUARY, 1);
        }
        do {
            System.out.println("Welcome to the Formula1 Championship");
            System.out.println("1. Add Players");
            System.out.println("2. Delete Players");
            System.out.println("3. View All Players");
            System.out.println("4. Register Team");
            System.out.println("5. View All Teams");
            System.out.println("6. Race");
            System.out.println("7. Real Race");
            System.out.println("8. Exit");
            select = scanInt();

            if (select == 1) {
                boolean flag = true;
                System.out.print("Enter Name: ");
                String name = scanStr();
                System.out.print("Enter Age: ");
                int age = scanInt();
                System.out.print("Enter Country: ");
                String cntry = scanStr();
                System.out.print("Enter Gender: ");
                String gndr = scanStr();
                System.out.print("Enter Team: ");
                String team = scanStr();
                for (CarCons c : f1CM.teams) {
                    if (c.getName().equals(team.toUpperCase(Locale.ROOT))) {
                        if (c.getDriver() != null) {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    CarCons newTeam = f1CM.makeTeam(team);
                    f1CM.addDriver(name, age, cntry, gndr, newTeam);
                } else {
                    System.out.println("Team already has a player.");
                }

            } else if (select == 2) {
                System.out.println("Current Drivers:");
                for (FormulaDriver d : f1CM.drivers) {
                    System.out.println(d.getName());
                }
                System.out.println("Which driver do you want to remove?");
                String rmvName = scanStr().toUpperCase(Locale.ROOT);
                f1CM.drivers.removeIf(d -> Objects.equals(d.getName(), rmvName));
            } else if (select == 3) {
                f1CM.displayOrderedDrivers();
            } else if (select == 4) {
                System.out.print("Enter Team Name: ");
                String teamName = scanStr();
                boolean isTeam = false;
                for (CarCons c : f1CM.teams) {
                    if (Objects.equals(c.getName(), teamName)) {
                        isTeam = true;
                        break;
                    }
                }
                if (isTeam) {
                    System.out.println("Team Already Exists.");
                } else {
                    f1CM.addTeam(teamName);
                }
            } else if (select == 5) {
                f1CM.displayTeams(f1CM.getTeams());
            } else if (select == 6) {
                f1CM.race();
            } else if (select == 7) {
                f1CM.weightedRace();
            } else if (select == 8) {
                System.out.println("Are you sure? y/n");
                String yn = scanStr();
                if (Objects.equals(yn, "n")) {
                    select = 0;
                } else {
                    FileWriteAndRead.fileWriter(f1CM.getDrivers());
                    DateWriteAndRead.fileWriter(f1CM.getRaceOrder());
                }
            }

        } while (select != 8);

    }

    static int scanInt() {
        Scanner intInput = new Scanner(System.in);
        return intInput.nextInt();
    }

    static String scanStr() {
        Scanner strInput = new Scanner(System.in);
        return strInput.nextLine();
    }

}


