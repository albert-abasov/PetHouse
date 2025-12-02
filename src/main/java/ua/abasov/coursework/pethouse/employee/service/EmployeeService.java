package ua.abasov.coursework.pethouse.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        return employeeRepository.updateEmployee(id, updatedEmployee);
    }

    public Employee updatePartOfEmployee(int id, Employee updatedEmployee) {
        Employee employee = employeeRepository.getEmployee(id);

        if (updatedEmployee.getName() != null) {
            employee.setName(updatedEmployee.getName());
        }

        if (updatedEmployee.getSurname() != null) {
            employee.setName(updatedEmployee.getName());
        }

        if (updatedEmployee.getAddress() != null) {
            employee.setAddress(updatedEmployee.getAddress());
        }

        if (updatedEmployee.getPhoneNumber() != null) {
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        }

        if (updatedEmployee.getQualification() != null) {
            employee.setQualification(updatedEmployee.getQualification());
        }

        employeeRepository.updateEmployee(id, employee);
        return employee;
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
