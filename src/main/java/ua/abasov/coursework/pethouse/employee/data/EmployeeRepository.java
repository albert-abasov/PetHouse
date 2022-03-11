package ua.abasov.coursework.pethouse.employee.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.abasov.coursework.pethouse.employee.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees",
                new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployee(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id = ?",
                new BeanPropertyRowMapper<>(Employee.class), id);
    }

    public Employee createEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees(name, surname, phoneNumber, address, qualifiction)" +
                        "VALUES(?, ?, ?, ?, ?)",
                employee.getName(), employee.getSurname(), employee.getPhoneNumber(),
                employee.getAddress(), employee.getQualification().name());

        return employee;
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        jdbcTemplate.update("UPDATE employees SET name = ?, surname = ?, phoneNumber = ?," +
                        "address = ?, qualification = ? WHERE id = ?",
                updatedEmployee.getName(), updatedEmployee.getSurname(), updatedEmployee.getPhoneNumber(),
                updatedEmployee.getAddress(), updatedEmployee.getQualification().name(), id);

        return updatedEmployee;
    }

    public void deleteEmployee(int id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id = ?", id);
    }
}
