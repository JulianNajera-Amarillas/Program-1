package com.company;

// Julian Najera-Amarillas
// Program 1: Company Employee Tracking System
// The purpose of this program is to function as an employee tracking system for a company

import java.util.Scanner;

public class Company {

    public static void main(String[] args) {

        // create scanner
        Scanner scan = new Scanner(System.in);
        // Create empty string for choice
        String choice = "";
        // Create Employee Array
        Employee[] EmployeeArray = new Employee[5];
        // Create Hourly Employee Array
        Employee[] HourlyEmployeeArray = new Employee[5];

        // Crate variables for use in program
        String name = "";
        double salary = 0;
        String hourlyWorker = "";
        int numberOfHoursWorked = 0;
        int numberOfEmployees = 0;
        String giveRaiseTo = "";
        double raise = 0;
        boolean found = false;
        boolean isInvalid = false;
        // if there is an hourly employee always use the hourly employee array to use the correct methods
        // try to keep indexes in both arrays equal

        do{
            if(isInvalid == false) {
                System.out.println("What do you want to do?");
                System.out.println("A. Add an Employee");
                System.out.println("B. List all Employees");
                System.out.println("C. Give an Employee a Raise");
                System.out.println("D. Give Paychecks");
                System.out.println("E. Change someones hours");
                System.out.println("F. Quit");
            }

            isInvalid = false;

            choice = scan.nextLine();
            choice = choice.toLowerCase();

            switch (choice) {
                case "a": // Add an employee
                    if(numberOfEmployees < 5) {
                        System.out.println("What is their name?");
                        name = scan.nextLine();
                        System.out.println("What is their salary (yearly or hourly)?");
                        salary = scan.nextDouble();
                        scan.nextLine();
                        System.out.println("Are they an hourly worker? (Y/N)");
                        hourlyWorker = scan.nextLine();
                        if(hourlyWorker.toLowerCase().equals("y")) {
                            System.out.println("How many hours per week do they work?");
                            numberOfHoursWorked = scan.nextInt();
                            scan.nextLine();
                        }
                        System.out.println(name + " was hired!");
                        EmployeeArray[numberOfEmployees] = new SoftwareEngineer(name, salary);
                        if(hourlyWorker.toLowerCase().equals("y")) {
                            HourlyEmployeeArray[numberOfEmployees] = new AdministrativeAssistant(name, salary, numberOfHoursWorked);
                        }
                        numberOfEmployees++;
                    } else {
                        System.out.println("Error, too many people work here already!");
                    }
                    break;

                case "b": // List all Employees // can say if number of employees == 0
                    if(EmployeeArray[0] == null) {
                        System.out.println("Nobody works here!");
                    } else {
                        for (int k = 0; k < numberOfEmployees; k++) {
                            if (HourlyEmployeeArray[k] != null) {
                                // compare if
                                System.out.println(EmployeeArray[k].getName() + " Hourly Wage: " + EmployeeArray[k].getSalary() + " Cash: " + EmployeeArray[k].getCash() + " Administrative Assistant");
                            } else {
                                System.out.println(EmployeeArray[k].getName() + " Salary: " + EmployeeArray[k].getSalary() + " Cash: " + EmployeeArray[k].getCash() + " Software Engineer");
                            }
                        }
                    }
                    break;
                case "c": // Give an Employee a Raise
                    found = false;
                    System.out.println("Who do you want to give a raise to?");
                    name = scan.nextLine();
                    for(int i = 0; i < numberOfEmployees; i++) {
                        if(name.equalsIgnoreCase(EmployeeArray[i].getName())) {
                            found = true;
                            System.out.println("What raise do you want to give them?");
                            raise = scan.nextDouble();
                            scan.nextLine(); // flush the scanner bc of the double previously
                            if(HourlyEmployeeArray[i] != null) {
                                HourlyEmployeeArray[i].giveRaise(raise); // ((AdministrativeAssistant) HourlyEmployeeArray[i]).giveRaise(raise); Must cast array position. Parenthesis between array position and .giveRaise(raise);
                                EmployeeArray[i] = HourlyEmployeeArray[i]; // Modify both indexes in both arrays. For example, if you changed name you would need to change it in both places
                            } else {
                                EmployeeArray[i].giveRaise(raise);
                            }
                            System.out.println(name + " is happy!");
                        }
                    }
                    if(!found) {
                        System.out.println("Error. " + name + " was not found.");
                    }
                    break;
                case "d": // Give paychecks
                    if(numberOfEmployees == 0) {
                        System.out.println("Error");
                    } else {
                        for (int k = 0; k < numberOfEmployees; k++) {
                            if (HourlyEmployeeArray[k] != null) {
                                // compare if
                                HourlyEmployeeArray[k].getPaid();
                                EmployeeArray[k] = HourlyEmployeeArray[k];  // Because we modified the amount of cash
                            } else {
                                EmployeeArray[k].getPaid();
                            }
                        }
                        System.out.println("Hooray for money!");
                    }
                    break;

                case "e": // Change someone's hours
                    found = false;
                    System.out.println("Change hours for who?");
                    name = scan.nextLine();
                    for(int i = 0; i < HourlyEmployeeArray.length; i++) {
                        if(HourlyEmployeeArray[i] != null && name.equalsIgnoreCase(HourlyEmployeeArray[i].getName())) {
                            System.out.println(HourlyEmployeeArray[i].getName() + " currently works " + ((AdministrativeAssistant)HourlyEmployeeArray[i]).getNumberOfHoursWorked() +  " hours per week. What would you like to change it to?");
                            numberOfHoursWorked = scan.nextInt();
                            scan.nextLine(); // flush scanner after nextInt
                            ((AdministrativeAssistant)HourlyEmployeeArray[i]).setNumberOfHoursWorked(numberOfHoursWorked); // need to typecast to use setNumberOfHoursWorked
                            EmployeeArray[i] = HourlyEmployeeArray[i]; // set equal bc we changed number of hours worked
                            System.out.println(HourlyEmployeeArray[i].getName() + " will now work " + ((AdministrativeAssistant)HourlyEmployeeArray[i]).getNumberOfHoursWorked() + " hours per week");
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Error");
                    }
                    break;


                case "f": // quit
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    isInvalid = true;

            }


        } while(!choice.toLowerCase().equals("f"));


    }
}
