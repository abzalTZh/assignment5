package kz.aitu.oop.practice.assignment5.repositories.Interfaces;

import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Hours;

import java.util.List;

public interface IUserRepository {
    boolean hireEmployee(Employee employee);
    Employee searchEmployee(String name, String surname);
    Employee fireEmployee(String name, String surname);
    List<Employee> getAllEmployee();
    List<Employee> getEmployee(String position);
    boolean updHours(String name, String surname, double hours);
    List<Hours> getHours();
}
