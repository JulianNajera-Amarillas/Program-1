package com.company;

public  interface Hourly {


    public abstract int getNumberOfHoursWorked();

    public abstract void setNumberOfHoursWorked(int numOfHours);

    public abstract void giveRaise(double incHourlyPay);

}
