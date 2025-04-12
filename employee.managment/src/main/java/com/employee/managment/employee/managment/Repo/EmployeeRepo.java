package com.employee.managment.employee.managment.Repo;

import com.employee.managment.employee.managment.entity.Department;
import com.employee.managment.employee.managment.entity.Employee;
import com.employee.managment.employee.managment.entity.enums.Designation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByDesignation(Designation designation);
    List<Employee> findByDepartment(Department department);
    @Query("SELECT e FROM Employee e WHERE e.salary.amount BETWEEN :min AND :max")
    List<Employee> findEmployeesBySalaryRange(@Param("min") Double min, @Param("max") Double max);
    Page<Employee> findAll(Pageable pageable);
}
