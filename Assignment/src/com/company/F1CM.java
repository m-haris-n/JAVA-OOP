package com.company;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;

public class F1CM implements CM{
    HashMap<Integer, Integer> posToPts = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> winProb = new HashMap<Integer, Integer>();
    ArrayList<FormulaDriver> drivers = new ArrayList<FormulaDriver>();
    ArrayList<CarCons> teams = new ArrayList<CarCons>();
    ArrayList<FormulaDriver> sortedDrivers = null;
    static final LocalDate date = LocalDate.of(2021, Month.JANUARY, 1);

    public ArrayList<FormulaDriver> getDrivers() {
        return this.drivers;
    }

    public ArrayList<CarCons> getTeams() { return this.teams; }

    public void sortDrivers(){
        ArrayList<FormulaDriver> drivers = this.getDrivers();
    }

    public void displayDrivers(ArrayList<FormulaDriver> drivers){
        for(FormulaDriver d: drivers){
            System.out.println(d);
        }
    }

    public void displayTeams(ArrayList<CarCons> teams){
        for(CarCons team: teams){
            System.out.println(team);
        }
    }

    public void posToPtsInit(){
        this.posToPts.put(1, 25);this.posToPts.put(2,18);this.posToPts.put(3,15);this.posToPts.put(4,12);this.posToPts.put(5,10);
        this.posToPts.put(6,8);this.posToPts.put(7,6);this.posToPts.put(8,4);this.posToPts.put(9,2);this.posToPts.put(10,1);
    }

    public void winProbInit(){
        winProb.put(1, 40);winProb.put(2, 30);winProb.put(3, 10);winProb.put(4, 10);winProb.put(5, 2);
        winProb.put(6, 2);winProb.put(7, 2);winProb.put(8, 2);winProb.put(9, 2);
    }

    public void addDriver(String name, int age, String country, String gender, CarCons team){
        boolean flag = true;
        for(FormulaDriver d: this.drivers){
            if (d.getTeam() == team) {
                flag = false;
                break;
            }
        }
        if(flag){
            this.teams.add(team);
            this.drivers.add(new FormulaDriver(name, age, country, gender, team));
        }
        else{
            System.out.println("Team "+team.getName()+" already has a driver.");
        }
    }

    public void changeTeamDriver(String driver, CarCons team){
        for(FormulaDriver d: this.drivers){
            if(d.team.getName() == team.getName()){
                d.setTeam(null);
                break;
            }
            if(d.getName()==driver){
                d.setTeam(team);
            }
        }
    }

    public void removeDriver(String name){
        for(FormulaDriver d: this.drivers){
            if(Objects.equals(d.getName(), name)){
                this.drivers.remove(d);
                break;
            }
        }
    }

    public void addTeam(String name){
        this.teams.add(new CarCons(name));
    }

    public CarCons makeTeam(String name){
        return new CarCons(name);
    }

    public void removeTeam(String name){
        for(FormulaDriver d: this.drivers){
            if(Objects.equals(d.getTeam().getName(), name)){
                this.drivers.remove(d);
                break;
            }
        }
        this.teams.removeIf(team -> team.getName() == name);
    }

    public int race(){
        int trackIdx = 0;
        int winIdx = 0;
        int size = this.drivers.size();

        Integer[] random = new Integer[size];
        for(int i = 0; i < size; i++){
            random[i] = i+1;
        }
        Collections.shuffle(Arrays.asList(random));
        System.out.println(Arrays.toString(random));
        int idx = 0;
        for(FormulaDriver d: this.drivers){
            d.raced();
            int pos = random[idx];
            d.incPos(pos);
            if(pos < 11){
                d.incScore(this.posToPts.get(pos));
                if(pos == 1) {winIdx=trackIdx;}
            }
            trackIdx++;
            idx++;
        }
        System.out.println(this.drivers.get(winIdx).name + "  has won the race.");
        return winIdx;
    }

    public int weightedRace(){
        Random rand = new Random();
        for(FormulaDriver d: this.drivers){
            d.raced();
            int pos = rand.nextInt(10) + 1;
            d.incPos(pos);
            d.incScore(this.posToPts.get(pos));
            int startPos = rand.nextInt(10) + 1;
            d.setStartPos(startPos);
            d.setWinProb(winProb.get(startPos));
        }
        FormulaDriver winner = this.weightedWin(this.drivers);

        assert winner != null;
        System.out.println(winner.getName() + " has won the race.");
        return 0;
    }

    private FormulaDriver weightedWin(ArrayList<FormulaDriver> drivers){
        int winner = 0;
        ArrayList<FormulaDriver> probWinners = new ArrayList<FormulaDriver>();
        for (FormulaDriver d: drivers){
            if(d.getStartPos()<=9){
                probWinners.add(d);
            }
        }
        Random rand = new Random();
        int prob = rand.nextInt(82);
        if (prob<2){
            winner = rand.nextInt(5)+5;
        }
        else if (prob<10+2){
            winner = rand.nextInt(2)+3;
        }
        else if (prob<30+10+2){
            winner = 2;
        }
        else {
            winner = 1;
        }
        for(FormulaDriver d: probWinners){
            if(d.getStartPos() == winner){
                return d;
            }
        }
        return null;
    }

}
