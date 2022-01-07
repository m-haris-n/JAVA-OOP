package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class F1CM implements CM{
    HashMap<Integer, Integer> posToPts = new HashMap<>();
    HashMap<Integer, Integer> winProb = new HashMap<>();
    ArrayList<FormulaDriver> drivers = new ArrayList<>();
    ArrayList<CarCons> teams = new ArrayList<>();
    ArrayList<FormulaDriver> sortedDrivers = null;
    HashMap<Integer, Integer> raceOrder = new HashMap<>();
    HashMap<Integer, Integer> ptsOrder = new HashMap<>();
    HashMap<Integer, Integer> posOrder = new HashMap<>();
    static final LocalDate date = LocalDate.of(2021, Month.JANUARY, 1);

    public ArrayList<FormulaDriver> getDrivers() {
        return this.drivers;
    }

    public ArrayList<CarCons> getTeams() { return this.teams; }


    public void setDrivers(ArrayList<FormulaDriver> drivers) {
        this.drivers = drivers;
    }

    public void setTeams(ArrayList<CarCons> teams) {
        this.teams = teams;
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

    public void setOrder(){
        HashMap<Integer, Integer> order = new HashMap<>();
        int iter = this.drivers.size();
        for(int i = 0; i < iter; i++){
            FormulaDriver d = this.drivers.get(i);
            if (d.getNumOfRaces()!=0){
                order.put(d.getCurrentPos(), i);
            }
        }
        System.out.println(order);
        this.posOrder = order;
        System.out.println(this.posOrder);
    }
    public HashMap<Integer, Integer> getPosOrder(){
        return this.posOrder;
    }


    public ArrayList<FormulaDriver> getOrderedDrivers(){
        this.setOrder();
        HashMap<Integer, Integer> order = getPosOrder();
        ArrayList<FormulaDriver> orderedDrivers = new ArrayList<>();
        if (!order.isEmpty()){
            for (int i = 1; i <= this.drivers.size(); i++){
                orderedDrivers.add(this.drivers.get(order.get(i)));
            }
        }
        return orderedDrivers;
    }

    public void displayRaceDrivers(ArrayList<FormulaDriver> sortedDrivers){
        for (FormulaDriver d: sortedDrivers){
            System.out.println(d);
        }
    }

    public ArrayList<FormulaDriver> setPtsOrder(){
        int iter = this.drivers.size();
        ArrayList<FormulaDriver> unordered = new ArrayList<>();
        for(int i = 0; i < iter; i++){
            FormulaDriver d = this.drivers.get(i);
            if (d.getScore() != 0) {
                this.ptsOrder.put(d.getScore(), i);
            } else {
                unordered.add(d);
            }
        }
        System.out.println(this.ptsOrder);
        return unordered;
    }

    public HashMap<Integer, Integer> getPtsOrder() {
        return this.ptsOrder;
    }

    public void displayOrderedDrivers(){
        ArrayList<FormulaDriver> unord = setPtsOrder();
        HashMap<Integer, Integer> order = getPtsOrder();
        ArrayList<FormulaDriver> orderedDrivers = new ArrayList<>();
        if (!order.isEmpty()){
            ArrayList<Integer> ord = new ArrayList<>(order.keySet());
            ord.sort(Comparator.reverseOrder());
            for (int i = 0; i < order.keySet().size(); i++){
                orderedDrivers.add(this.drivers.get(order.get(ord.get(i))));
            }
            orderedDrivers.addAll(unord);
        }
        this.sortedDrivers = orderedDrivers;
        System.out.println(orderedDrivers);
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
            if(Objects.equals(d.team.getName(), team.getName())){
                d.setTeam(null);
                break;
            }
            if(Objects.equals(d.getName(), driver)){
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
        this.teams.removeIf(team -> Objects.equals(team.getName(), name));
    }

    public void race(){
        int trackIdx = 0;
        int winIdx = 0;
        int size = this.drivers.size();

        Integer[] random = this.generateRandomPos(size);
        int idx = 0;
        for(FormulaDriver d: this.drivers){
            d.raced();
            int pos = random[idx];
            d.setCurrentPos(pos);
            if(pos < 11){
                d.incPos(pos);
                d.incScore(this.posToPts.get(pos));
                if(pos == 1) {winIdx=trackIdx;}
            }
            trackIdx++;
            idx++;
        }
        System.out.println(this.drivers.get(winIdx).name + "  has won the race.");
        this.displayRaceDrivers(getOrderedDrivers());
    }

    public Integer[] generateRandomPos(int size){
        Integer[] random = new Integer[size];
        for(int i = 0; i < size; i++){
            random[i] = i+1;
        }
        Collections.shuffle(Arrays.asList(random));
        return random;
    }

    public void weightedRace(){
        Integer[] randPos = this.generateRandomPos(this.drivers.size());
        int otherPos = 2;
        for(int i = 0; i < this.drivers.size(); i++){
            this.drivers.get(i).setStartPos(randPos[i]);
        }
        int winIdx = weightedWin();
        for (FormulaDriver d: this.drivers){
            if(d.getStartPos()<=10){
                if(d.getStartPos()!=drivers.get(winIdx).getStartPos()){
                    d.incPos(otherPos);
                    d.incScore(this.posToPts.get(otherPos));
                    otherPos++;
                }
            }
        }

        System.out.println(this.drivers.get(winIdx).getName() + " has won.");
        this.displayRaceDrivers(getOrderedDrivers());
    }

    private int weightedWin(){
        int winner;
        int winIdx = 0;

        Random rand = new Random();
        int prob = rand.nextInt(82);
        if (prob<2){
            winner = rand.nextInt(5)+5;
        }
        else if (prob<(10+2)){
            winner = rand.nextInt(2)+3;
        }
        else if (prob<(30+10+2)){
            winner = 2;
        }
        else {
            winner = 1;
        }
        for(FormulaDriver d: drivers){
            if(d.getStartPos() == winner){
                d.incPos(1);
                d.incScore(this.posToPts.get(1));
                winIdx = drivers.indexOf(d);
            }
        }
        return winIdx;
    }


}

