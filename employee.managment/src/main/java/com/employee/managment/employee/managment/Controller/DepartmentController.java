package com.employee.managment.employee.managment.Controller;

import com.employee.managment.employee.managment.Service.DepartmentService;
import com.employee.managment.employee.managment.entity.Department;
import com.employee.managment.employee.managment.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
public class DepartmentController {
    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }
    @PostMapping("/create-employee")
    public ResponseEntity<Department> createEmployee(@RequestBody Department department,@RequestBody Employee employee){
        return ResponseEntity.ok(departmentService.createEmployee(department,employee));
    }

}
