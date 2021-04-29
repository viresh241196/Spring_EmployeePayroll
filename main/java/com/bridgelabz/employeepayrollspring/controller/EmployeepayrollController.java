package com.bridgelabz.employeepayrollspring.controller;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollspring.model.Employee;

import com.bridgelabz.employeepayrollspring.services.IEmployeepayrollService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Getter
@RestController
@RequestMapping("/employeepayroll")
public class EmployeepayrollController {

    @Autowired
    private IEmployeepayrollService employeepayrollService;

    @GetMapping("")
    public List<Employee> getEmployeepayrollData() {
        return employeepayrollService.getEmployeepayrollData();
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO>  getEmployeepayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = employeepayrollService.getEmployeepayrollDataById(empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO>  addEmployeepayrollData(@RequestBody @Valid EmployeepayrollDTO emppayrollDTO) {
        Employee employee=employeepayrollService.createEmployeepayrollData(emppayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("post created successfully",employee);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeepayrollData(@RequestBody @Valid EmployeepayrollDTO emprollDTO,@PathVariable("empId") int empId) {
        Employee employee= employeepayrollService.updateEmployeepayrollData(empId,emprollDTO);
        ResponseDTO respDTO = new ResponseDTO("updated successfully", employee);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeepayrollData(@PathVariable("empId") int empId){
        Boolean result =  employeepayrollService.deleteEmployeepayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Delete process status:", result);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
