package ua.abasov.coursework.pethouse.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.employee.model.Employee;
import ua.abasov.coursework.pethouse.employee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @PatchMapping("/{id}")
    public Employee updatePartOfEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeService.updatePartOfEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}
