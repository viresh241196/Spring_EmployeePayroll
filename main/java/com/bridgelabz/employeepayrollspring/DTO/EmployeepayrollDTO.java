package com.bridgelabz.employeepayrollspring.DTO;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class EmployeepayrollDTO {

    @NotBlank(message = "employee name can't be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$",message = "minimum 3 char and first capital char is required")
    public String name;
    @Min(value = 500,message = "Min Wage should be 500")
    public long salary;

    public EmployeepayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
    }
}
