package com.employee.managment.employee.managment.entity;

import com.employee.managment.employee.managment.entity.enums.Designation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Designation designation;

    private LocalDate joiningDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Department department;

    @OneToOne(mappedBy = "employee")
    @JsonIgnore
    private Salary salary;

    public Employee() {
    }

    public Employee(Long id, String name, Designation designation, LocalDate joiningDate, Department department, Salary salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
