package com.company;

import java.util.ArrayList;

public interface CM {


    public ArrayList<FormulaDriver> getDrivers();
    public void addDriver(String name, int age, String country, String gender, CarCons team);
    public void changeTeamDriver(String driver, CarCons team);
    public void removeDriver(String name);
    public void removeTeam(String name);
    public int race();
    public int weightedRace();
}
