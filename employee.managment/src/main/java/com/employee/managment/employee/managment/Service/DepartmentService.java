package com.employee.managment.employee.managment.Service;

import com.employee.managment.employee.managment.Repo.DepartmentRepo;
import com.employee.managment.employee.managment.entity.Department;
import com.employee.managment.employee.managment.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    public final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department createDepartment(Department department) {
        Department department1=new Department();
        department1.setLocation(department.getLocation());
        department1.setName(department.getName());
        return departmentRepo.save(department);
    }

}
