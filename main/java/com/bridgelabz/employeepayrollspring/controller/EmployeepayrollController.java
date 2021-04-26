package com.bridgelabz.employeepayrollspring.controller;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeepayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeepayrollController {

    @RequestMapping("")
    public ResponseEntity<ResponseDTO> getEmployeepayrollData() {
        EmployeepayrollData empData = new EmployeepayrollData(1, new EmployeepayrollDTO("viresh", 3000L));
        ResponseDTO respDTO = new ResponseDTO("get call successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeepayrollData(@PathVariable("empId") int empId) {
        EmployeepayrollData empData = new EmployeepayrollData(empId, new EmployeepayrollDTO("viresh", 3000L));
        ResponseDTO respDTO = new ResponseDTO("get call for ID successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeepayrollData(@RequestBody EmployeepayrollDTO emprollDTO) {
        EmployeepayrollData empData = new EmployeepayrollData(1, emprollDTO);
        ResponseDTO respDTO = new ResponseDTO("post created successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeepayrollData(@RequestBody EmployeepayrollDTO emprollDTO) {
        EmployeepayrollData empData = new EmployeepayrollData(1, emprollDTO);
        ResponseDTO respDTO = new ResponseDTO("updated successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeepayrollData(@PathVariable("empId") int empId){
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully Id:", empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
