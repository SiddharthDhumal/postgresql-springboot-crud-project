package com.practicepostgresql.postgresql.service.serviceImpl;

import com.practicepostgresql.postgresql.exception.ResourceNotFoundException;
import com.practicepostgresql.postgresql.model.Employee;
import com.practicepostgresql.postgresql.repository.EmployeeRepository;
import com.practicepostgresql.postgresql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee does not exists with id :" + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exists with id :" + id));

        System.out.println(employeeDetails.getFirstName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employee.getEmailId());

        return employeeRepository.save(employee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exists with id :" + id));

        employeeRepository.delete(employee);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);

        return response;
    }
}
