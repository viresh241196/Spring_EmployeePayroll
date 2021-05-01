package com.bridgelabz.employeepayrollspring.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
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

    @JsonFormat(pattern = "yyyy-mm-dd")
    @NotNull(message="date can't be null")
//    @PastOrPresent(message = "startDate should be past or present")
    public String startDate;

    @NotBlank(message = "cannot be empty")
    public String note;
    @NotNull(message="cannot be empty")
    public String profilePic;
    @NotNull(message="department cannot be empty")
    public List<String> departments;

    public EmployeepayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
    }
}
