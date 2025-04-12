package com.employee.managment.employee.managment.Repo;

import com.employee.managment.employee.managment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
