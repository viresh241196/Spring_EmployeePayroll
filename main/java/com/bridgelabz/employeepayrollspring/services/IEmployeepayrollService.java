package com.bridgelabz.employeepayrollspring.services;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollspring.model.Employee;

import java.util.List;

public interface IEmployeepayrollService {
    List<Employee> getEmployeepayrollData();

    ResponseDTO getEmployeepayrollDataById(int empId);

    Employee createEmployeepayrollData(EmployeepayrollDTO empayrollDTO);

    Employee updateEmployeepayrollData(int empId, EmployeepayrollDTO empayrollDTO);

    Boolean deleteEmployeepayrollData(int empId);
}
