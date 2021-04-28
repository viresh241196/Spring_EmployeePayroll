package com.bridgelabz.employeepayrollspring.DTO;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class EmployeepayrollDTO {
    @NotBlank(message = "employee name can't be null")
    public String name;
    @Min(value = 500,message = "Min Wage should be 500")
    public long salary;

    public EmployeepayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
    }
}
