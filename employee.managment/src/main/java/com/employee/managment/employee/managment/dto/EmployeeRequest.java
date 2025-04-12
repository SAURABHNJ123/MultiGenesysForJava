package com.employee.managment.employee.managment.dto;

import com.employee.managment.employee.managment.entity.enums.Designation;

import java.time.LocalDate;

public class EmployeeRequest {
    private String name;
    private Designation designation;
    private LocalDate joiningDate;
    private Long departmentId;  // ID of the department to which this employee belongs

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, Designation designation, LocalDate joiningDate, Long departmentId) {
        this.name = name;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.departmentId = departmentId;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}

