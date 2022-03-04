package ua.abasov.coursework.pethouse.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.abasov.coursework.pethouse.employee.data.EmployeeRepository;
import ua.abasov.coursework.pethouse.employee.model.Employee;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployee(int id, Employee newEmployee) {
        return employeeRepository.updateEmployee(id, newEmployee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
