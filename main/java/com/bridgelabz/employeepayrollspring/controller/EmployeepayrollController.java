package com.bridgelabz.employeepayrollspring.controller;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeepayrollData;
import com.bridgelabz.employeepayrollspring.services.IEmployeepayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeepayrollController {

    @Autowired
    private IEmployeepayrollService employeepayrollService;

    @RequestMapping("")
    public ResponseEntity<ResponseDTO> getEmployeepayrollData() {
        List<EmployeepayrollData> empData = employeepayrollService.getEmployeepayrollData();
        ResponseDTO respDTO = new ResponseDTO("get call successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeepayrollData(@PathVariable("empId") int empId) {
        EmployeepayrollData empData = employeepayrollService.getEmployeepayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("get call for ID successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeepayrollData(@RequestBody EmployeepayrollDTO emprollDTO) {
        EmployeepayrollData empData = employeepayrollService.createEmployeepayrollData(emprollDTO);
        ResponseDTO respDTO = new ResponseDTO("post created successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeepayrollData(@RequestBody EmployeepayrollDTO emprollDTO,@PathVariable("empId") int empId) {
        EmployeepayrollData empData = employeepayrollService.updateEmployeepayrollData(empId,emprollDTO);
        ResponseDTO respDTO = new ResponseDTO("updated successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeepayrollData(@PathVariable("empId") int empId){
        employeepayrollService.deleteEmployeepayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully Id:", empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
