package com.revature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDaoImpl implements EmployeeDao{
    Connection connection;

    public EmployeeDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (name, email) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Employee saved");
        } else {
            System.out.println("Oops! Something went wrong!");
        }
    }

    @Override
    public void updateEmployee(int id) throws SQLException {
        String sql = "UPDATE employee SET name=?, email=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.next();
        preparedStatement.setString(1, name);
        System.out.println("Enter email: ");
        String email = scanner.next();
        preparedStatement.setString(2, email);
        preparedStatement.setInt(3, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Employee updated");
        } else {
            System.out.println("Oops! Something went wrong!");
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Delete employee with id: " + id);
        } else {
            System.out.println("Oops! Looks like something went wrong!");
        }
    }

    @Override
    public List<Employee> getEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Employee employee = new Employee(id, name, email);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        List<Employee> employees = getEmployee();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
