package com.revature;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getEmployee();
    Employee getEmployeeById(int id);

}
