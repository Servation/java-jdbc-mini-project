package com.revature;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Employee Dao
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        
        Employee employee = new Employee();
        employee.setName("Mark");
        employee.setEmail("m@gmail.com");

        dao.addEmployee(employee);
    }
}
