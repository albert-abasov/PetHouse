package ua.abasov.coursework.pethouse.employee.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private EmployeeQualification qualification;
}
