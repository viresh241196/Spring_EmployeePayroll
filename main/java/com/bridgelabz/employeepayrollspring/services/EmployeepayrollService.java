package com.bridgelabz.employeepayrollspring.services;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeepayrollData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeepayrollService implements IEmployeepayrollService{

    @Override
    public List<EmployeepayrollData> getEmployeepayrollData() {
        List<EmployeepayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeepayrollData(1,new EmployeepayrollDTO("viresh",3000)));
        return empDataList;
    }

    @Override
    public EmployeepayrollData getEmployeepayrollDataById(int empId) {
        EmployeepayrollData empData = new EmployeepayrollData(1,new EmployeepayrollDTO("viresh",3000));
        return empData;
    }

    @Override
    public EmployeepayrollData createEmployeepayrollData(EmployeepayrollDTO empayrollDTO) {
        EmployeepayrollData empData = new EmployeepayrollData(1,empayrollDTO);
        return empData;
    }

    @Override
    public EmployeepayrollData updateEmployeepayrollData(int empId, EmployeepayrollDTO empayrollDTO) {
        EmployeepayrollData empData = new EmployeepayrollData(1,empayrollDTO);
        return empData;
    }

    @Override
    public void deleteEmployeepayrollData(int empId) {

    }
}
