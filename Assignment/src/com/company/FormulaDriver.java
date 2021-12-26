package com.company;

import java.util.Arrays;

public class FormulaDriver extends Driver{

    int score = 0;
    int numOfRaces = 0;
    int[] pos = new int[10];
    int startPos = 0;
    int winProb = 0;

    public FormulaDriver(String name, int age, String country, String gender) {
        super(name, age, country, gender);
        this.score = 0;
        this.numOfRaces = 0;
    }
    public FormulaDriver(String name, int age, String country, String gender, CarCons team) {
        this(name, age, country, gender);
        this.team = team;
        this.team.setDriver(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumOfRaces() {
        return numOfRaces;
    }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces = numOfRaces;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getWinProb() {
        return winProb;
    }

    public void setWinProb(int winProb) {
        this.winProb = winProb;
    }

    void incScore(int pts){
        this.score += pts;
    }

    void incPos(int pos){
        for(int i = 0; i < 10; i++){
            if((pos-1) == i){
                this.pos[i]++;
                break;
            }
        }
    }

    void raced(){
        this.numOfRaces++;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Age: " + age + '\n' +
                "Country: " + country + '\n' +
                "Team: " + team.name + '\n' +
                "Gender: " + gender + '\n' +
                "Score: " + score + '\n' +
                "Number of Races: " + numOfRaces + '\n' +
                "Position: " + Arrays.toString(pos);
    }

}
