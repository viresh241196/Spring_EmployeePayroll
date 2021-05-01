package com.bridgelabz.employeepayrollspring.services;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollspring.exception.EmployeeCustomException;
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
public class EmployeepayrollService implements IEmployeepayrollService {
    private List<EmployeepayrollData> empDataList = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeepayrollData() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public ResponseDTO getEmployeepayrollDataById(int empId) {
        ResponseDTO respDTO = new ResponseDTO();
        try {
            Optional<Employee> employee = employeeRepository.findById(empId);
            if (employee.isPresent()) {
                respDTO.setData(employee.get());
                respDTO.setMessage("successfully");
            } else {
                throw new EmployeeCustomException("Employee not Found");
            }
        } catch (Exception e) {
            throw new EmployeeCustomException("something went wrong");
        }
        return respDTO;
    }

    @Override
    public Employee createEmployeepayrollData(EmployeepayrollDTO empayrollDTO) {
        System.out.println(empayrollDTO.startDate);
        return employeeRepository.save(new Employee(empayrollDTO));
    }

    @Override
    public Employee updateEmployeepayrollData(int empId, EmployeepayrollDTO empayrollDTO) {
        Employee newEmployee = new Employee(empId,empayrollDTO);
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Boolean deleteEmployeepayrollData(int empId) {
        try {
            ResponseDTO emp = this.getEmployeepayrollDataById(empId);
            Employee employee= (Employee) emp.getData();
            employeeRepository.delete(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
