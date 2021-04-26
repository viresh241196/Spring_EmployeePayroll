package com.bridgelabz.employeepayrollspring.services;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeepayrollData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeepayrollService implements IEmployeepayrollService{
    private List<EmployeepayrollData> empDataList = new ArrayList<>();

    @Override
    public List<EmployeepayrollData> getEmployeepayrollData() {
        return empDataList;
    }

    @Override
    public EmployeepayrollData getEmployeepayrollDataById(int empId) {
        return empDataList.get(empId-1);
    }

    @Override
    public EmployeepayrollData createEmployeepayrollData(EmployeepayrollDTO empayrollDTO) {
        EmployeepayrollData empData = new EmployeepayrollData(empDataList.size()+1, empayrollDTO);
        empDataList.add(empData);
        return empData;
    }

    @Override
    public EmployeepayrollData updateEmployeepayrollData(int empId, EmployeepayrollDTO empayrollDTO) {
        EmployeepayrollData empData = this.getEmployeepayrollDataById(empId);
        empData.setName(empayrollDTO.name);
        empData.setSalary(empayrollDTO.salary);
        empDataList.set(empId-1,empData);
        return empData;
    }

    @Override
    public void deleteEmployeepayrollData(int empId) {
    empDataList.remove(empId-1);
    }
}
