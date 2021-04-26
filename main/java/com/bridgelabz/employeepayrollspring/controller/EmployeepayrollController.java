package com.bridgelabz.employeepayrollspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeepayrollController {

    @GetMapping("")
    public String greeting(){
        return "Hello";
    }
}
