package com.employee.managment.employee.managment.Controller;

import com.employee.managment.employee.managment.Service.EmployeeService;
import com.employee.managment.employee.managment.dto.EmployeeRequest;
import com.employee.managment.employee.managment.entity.Employee;
import com.employee.managment.employee.managment.entity.enums.Designation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<Employee>> getAllEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(employeeService.getAllEmployeesPaginated(page, size));
    }

    @GetMapping("/by-salary-range")
    public ResponseEntity<List<Employee>> retrieveEmployeeBySalaryRange(@RequestParam(defaultValue = "0") Double minSalary,
                                                                        @RequestParam(defaultValue ="1.7976931348623157E308") Double maxSalary) {
        return ResponseEntity.ok(employeeService.retrieveEmployeeBySalaryRange(minSalary, maxSalary));
    }

    @GetMapping("/by-department/{departmentId}")
    public ResponseEntity<List<Employee>> retrieveEmployeeByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(employeeService.retrieveEmployeeByDepartment(departmentId));
    }

    @GetMapping("/by-designation")
    public ResponseEntity<List<Employee>> getEmployeesByDesignation(@RequestParam(defaultValue = "DEVELOPER") Designation designation) {
        List<Employee> employees = employeeService.getEmployeesByDesignation(designation);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/create-employee-under-department")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee savedEmployee = employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
