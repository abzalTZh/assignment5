package kz.aitu.oop.practice.assignment5.data;

import kz.aitu.oop.practice.assignment5.data.Interfaces.IDB;

import java.sql.*;

public class DB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        //connects to the database through URL
        String connectionURL = "jdbc:postgresql://localhost:5432/companyDB";
        try {
            //Load driver's class file into the memory
            Class.forName("org.postgresql.Driver");

            //Establish the connection
            Connection con = DriverManager.getConnection(connectionURL, "postgres", "123456");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
