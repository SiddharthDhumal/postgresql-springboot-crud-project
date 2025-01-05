package com.practicepostgresql.postgresql.service;

import com.practicepostgresql.postgresql.model.Employee;


import java.util.List;
import java.util.Map;


public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee createEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public Employee  updateEmployee(Long id,Employee employeeDetails);

    public Map<String,Boolean> deleteEmployee(Long id);
}
