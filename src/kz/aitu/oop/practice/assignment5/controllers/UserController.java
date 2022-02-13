package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Hours;
import kz.aitu.oop.practice.assignment5.repositories.Interfaces.IUserRepository;

import java.util.List;

public class UserController {
    //Create a controller to interact with the database in the Main.java file of the programm

    private IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String hireEmployee (String name, String surname, String dateOfBirth, String position, int employmentYear) {
        Employee employee = new Employee(name, surname, dateOfBirth, position, employmentYear);

        boolean created = repo.hireEmployee(employee);

        if (created == true) {
            return "Employee has been hired and added to the database!";
        } else {
            return "The process habe failed!";
        }
    }

    public String getEmployee(String position) {
        List<Employee> employees = repo.getEmployee(position);

        return employees.toString();
    }

    public String searchEmployee(String name, String surname) {
        Employee employee = repo.searchEmployee(name, surname);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String fireEmployee(String name,String surname) {
        Employee employee = repo.fireEmployee(name, surname);

        return (employee == null ? "Employee was not found!" : employee.getName() + " " + employee.getSurname() + " has been fired and deleted from the database");
    }

    public void updHours(String name, String surname, double hours) {
        boolean updated = repo.updHours(name, surname, hours);

//        if (updated == true) {
//            return "Hours have been updated!";
//        } else {
//            return "The process have failed!";
//        }
    }

    public String getAllEmployee() {
        List<Employee> employees = repo.getAllEmployee();

        return employees.toString();
    }

    public String getHours() {
        List<Hours> hours = repo.getHours();

        return hours.toString();
    }
}
