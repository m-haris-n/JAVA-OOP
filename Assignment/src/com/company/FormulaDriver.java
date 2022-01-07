package com.company;

import java.util.Arrays;

public class FormulaDriver extends Driver{



    public FormulaDriver(String name, int age, String country, String gender, CarCons team) {
        super(name, age, country, gender);
        this.team = team;
        this.teamName = this.team.getName();
        this.team.setDriver(this);
        this.score = 0;
        this.numOfRaces = 0;
        this.startPos = 9;
        this.winProb = 0;
        this.currentPos = 0;
        this.numOfRaces = 0;
    }

    public FormulaDriver(String name, int age, String country, String gender, String team, int score, int numOfRaces, int[] pos, int startPos, int winProb, int currentPos) {
        super(name, age, country, gender);
        this.teamName = team;
        this.team = new CarCons(team);
        this.team.setDriver(this);
        this.score = score;
        this.numOfRaces = numOfRaces;
        this.pos = pos;
        this.startPos = startPos;
        this.winProb = winProb;
        this.currentPos = currentPos;
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

    public int getCurrentPos() { return currentPos; }

    public void setCurrentPos(int currentPos) { this.currentPos = currentPos; }

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
