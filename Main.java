package com.revature;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Employee Dao
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("*************************");
            System.out.println("Select from the options below: ");
            System.out.println("*************************");
            System.out.println("Enter 1: Add to Employee");
            System.out.println("Enter 2: Update Employee");
            System.out.println("Enter 3: Delete from Employee");
            System.out.println("Enter 4: Get all Employees");
            System.out.println("Enter 5: Get Employee By ID");
            System.out.println("Enter 6: EXIT");
            System.out.println("*************************");

            int input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    //add
                    System.out.println("Enter name: ");
                    String name = scan.next();
                    System.out.println("Enter email: ");
                    String email = scan.next();
                    Employee newEmployee = new Employee();
                    newEmployee.setName(name);
                    newEmployee.setEmail(email);
                    dao.addEmployee(newEmployee);
                }
                case 2 -> {
                    // update
                    System.out.println("Choose id to update: ");
                    int id = scan.nextInt();
                    dao.updateEmployee(id);
                }
                case 3 -> {
                    // delete
                    System.out.println("Choose record by id to delete: ");
                    int id = scan.nextInt();
                    dao.deleteEmployee(id);
                }
                case 4 -> {
                    // get all
                    List<Employee> employees = dao.getEmployee();
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                }
                case 5 -> {
                    // get employee by id
                    System.out.println("Choose an id to look up: ");
                    int id = scan.nextInt();
                    Employee employee = dao.getEmployeeById(id);
                    if (employee == null)
                        System.out.println("Could not find employee with the id: " + id);
                    else
                    System.out.println(employee);
                }
                case 6 -> {
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    ConnectionFactory.closeConnection();
                }
                default -> System.out.println("Choose between 1-6");
            }
        }

    }
}
