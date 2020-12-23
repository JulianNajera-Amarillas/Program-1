package com.company;

public class AdministrativeAssistant extends Employee implements Hourly {

    int numberOfHoursWorked;

    public AdministrativeAssistant(String name, double salary, int numberOfHoursWorked) {
        this.name = name;
        this.salary = salary;
        this.numberOfHoursWorked = numberOfHoursWorked;
        this.cash = 0;
    }

    //@Override
    public int getNumberOfHoursWorked() {
        return this.numberOfHoursWorked;
    }

    // may need to override
    public void setNumberOfHoursWorked(int numberOfHoursWorked) {
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    //@Override
    /*public void changeHoursWorked(int numOfHours) {
        this.numberOfHoursWorked = numOfHours;
    }*/

    //@Override
    public void giveRaise(double incHourlyPay) {
        this.salary = (salary + incHourlyPay);
    }

    public void getPaid() {
        this.cash = cash + (salary * (numberOfHoursWorked * 2));
    }

}
