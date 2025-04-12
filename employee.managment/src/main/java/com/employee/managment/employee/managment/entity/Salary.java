package com.employee.managment.employee.managment.entity;

import jakarta.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Salary() {
    }

    public Salary(Long id, Double amount, Employee employee) {
        this.id = id;
        this.amount = amount;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
