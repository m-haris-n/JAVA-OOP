package com.company;

import java.util.Locale;

public class CarCons {
    String name;
    FormulaDriver driver = null;

    public CarCons(String name) {
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public FormulaDriver getDriver() {
        return driver;
    }

    public void setDriver(FormulaDriver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Team " + name + ", Driver " + driver.getName() + '\n';
    }
}
