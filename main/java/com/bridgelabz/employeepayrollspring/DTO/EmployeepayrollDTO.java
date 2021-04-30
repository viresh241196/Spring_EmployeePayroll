package com.bridgelabz.employeepayrollspring.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class EmployeepayrollDTO {

    @NotBlank(message = "employee name can't be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$",message = "minimum 3 char and first capital char is required")
    public String name;
    @Min(value = 500,message = "Min Wage should be 500")
    public long salary;
    @Pattern(regexp = "male|female",message = "gender should be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MM YYYY")
//    @NonNull(message="date can't be null")
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> department;

    public EmployeepayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
    }
}
