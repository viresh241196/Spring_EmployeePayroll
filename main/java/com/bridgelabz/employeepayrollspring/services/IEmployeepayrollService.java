package com.bridgelabz.employeepayrollspring.services;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeepayrollData;

import java.util.List;

public interface IEmployeepayrollService {
    List<EmployeepayrollData> getEmployeepayrollData();

    EmployeepayrollData getEmployeepayrollDataById(int empId);

    EmployeepayrollData createEmployeepayrollData(EmployeepayrollDTO empayrollDTO);

    EmployeepayrollData updateEmployeepayrollData(int empId, EmployeepayrollDTO empayrollDTO);

    void deleteEmployeepayrollData(int empId);
}
