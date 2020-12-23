package com.company;

public class SoftwareEngineer extends Employee {


    public SoftwareEngineer(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.cash = 0;

    }
    //@Override
    public void giveRaise(double incSalaryBy) {

        this.salary = salary + (salary*(incSalaryBy/100));
    }
}
