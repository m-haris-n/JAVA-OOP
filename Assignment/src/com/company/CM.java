package com.company;

import java.util.ArrayList;

public interface CM {


    ArrayList<FormulaDriver> getDrivers();

    void addDriver(String name, int age, String country, String gender, CarCons team);

    void changeTeamDriver(String driver, CarCons team);

    void removeDriver(String name);

    void removeTeam(String name);

    void race();

    void weightedRace();

}
