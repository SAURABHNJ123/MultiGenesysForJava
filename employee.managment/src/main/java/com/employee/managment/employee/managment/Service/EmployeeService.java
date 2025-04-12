package com.employee.managment.employee.managment.Service;

import com.employee.managment.employee.managment.Repo.DepartmentRepo;
import com.employee.managment.employee.managment.Repo.EmployeeRepo;
import com.employee.managment.employee.managment.entity.Department;
import com.employee.managment.employee.managment.entity.Employee;
import com.employee.managment.employee.managment.entity.enums.Designation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    public EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public Page<Employee> getAllEmployeesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepo.findAll(pageable);
    }


    public List<Employee> retrieveEmployeeByDesignation(Designation designation) {
        return employeeRepo.findByDesignation(designation);
    }

    public List<Employee> retrieveEmployeeBySalaryRange(Double minSalary, Double maxSalary) {
        return employeeRepo.findEmployeesBySalaryRange(minSalary, maxSalary);
    }

    public List<Employee> retrieveEmployeeByDepartment(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);
        return optionalDepartment.map(employeeRepo::findByDepartment).orElseThrow(() ->
                new RuntimeException("Department not found with ID: " + departmentId));
    }
}
