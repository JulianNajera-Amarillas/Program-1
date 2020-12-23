package com.company;

public abstract class Employee {

    protected String name;
    protected double salary;
    protected double cash;

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public void getPaid() {
        cash = cash + (salary / 26);
    }

    public double getSalary() {
        return salary;
    }

    public abstract void giveRaise(double incSalaryBy);



}
