package com.bridgelabz.employeepayrollspring.services;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.model.Employee;
import com.bridgelabz.employeepayrollspring.model.EmployeepayrollData;
import com.bridgelabz.employeepayrollspring.repository.EmployeeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@Service
public class EmployeepayrollService implements IEmployeepayrollService{
    private List<EmployeepayrollData> empDataList = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeepayrollData() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeepayrollDataById(int empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        return employee.get();
    }

    @Override
    public Employee createEmployeepayrollData(EmployeepayrollDTO empayrollDTO) {
        return employeeRepository.save(new Employee(empayrollDTO.getName(),empayrollDTO.getSalary()));
    }

    @Override
    public Employee updateEmployeepayrollData(int empId, EmployeepayrollDTO empayrollDTO) {
        Employee employee = this.getEmployeepayrollDataById(empId);
        employee.setName(empayrollDTO.getName());
        employee.setSalary(empayrollDTO.getSalary());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Boolean deleteEmployeepayrollData(int empId) {
        try {
            Employee employee = this.getEmployeepayrollDataById(empId);
            employeeRepository.save(employee);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
