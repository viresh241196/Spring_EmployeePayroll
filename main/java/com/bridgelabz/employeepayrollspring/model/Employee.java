package com.bridgelabz.employeepayrollspring.model;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int empId;
    public String name;
    public long salary;

    public Employee() {
        empId=0;
        name="";
        salary=0L;

    }
    public Employee(String name,long salary) {
        this.empId= empId;
        this.name= name;
        this.salary= salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}

