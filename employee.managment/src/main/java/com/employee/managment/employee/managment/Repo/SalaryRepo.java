package com.employee.managment.employee.managment.Repo;

import com.employee.managment.employee.managment.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salary,Long> {
}
