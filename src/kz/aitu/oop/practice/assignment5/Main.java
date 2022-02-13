package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.UserController;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Hours;
import kz.aitu.oop.practice.assignment5.repositories.Interfaces.IUserRepository;
import kz.aitu.oop.practice.assignment5.repositories.UserRepository;
import kz.aitu.oop.practice.assignment5.data.Interfaces.IDB;
import kz.aitu.oop.practice.assignment5.data.DB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        IDB db = new DB();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);

//        System.out.println(controller.hireEmployee("Mark", "Doe", "02/05/1998", "BackEnd", 2021));
//        System.out.println(controller.hireEmployee("Amanda", "Stews", "12/21/2001", "BackEnd", 2021));

//        System.out.println(controller.updHours("Amanda", "Stews", 21.5));
//        controller.updHours("Mark", "Doe", 13.0);

//        System.out.println(controller.hireEmployee("Lisa", "Krakov", "05/07/2000", "SysAdmin", 2020));
//        System.out.println(controller.fireEmployee("Lisa", "Krakov"));

        System.out.println(controller.getEmployee("BackEnd"));
        System.out.println(controller.searchEmployee("Amanda", "Stews"));
        System.out.println(controller.getAllEmployee());
        System.out.println(controller.getHours());
    }
}
