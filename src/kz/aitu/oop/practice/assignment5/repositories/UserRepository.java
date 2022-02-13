package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.Interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Hours;
import kz.aitu.oop.practice.assignment5.repositories.Interfaces.IUserRepository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        //Establish connection as null
        Connection con = null;
        try {
            //Connect to the database
            con = db.getConnection();
            //Write statement that will be used in the SQL Query
            String sql = "INSERT INTO employees(name, surname, dateofbirth, position, employment_year) VALUES (?, ?, ?, ?, ?); INSERT INTO hourstable(name, surname, position, hours) VALUES (?, ?, ?, 0)";
            //Sends parametrized SQL statements to the database
            PreparedStatement st = con.prepareStatement(sql);

            //Sets values to given variables
            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getDateOfBirth());
            st.setString(4, employee.getPosition());
            st.setInt(5, employee.getEmploymentYear());
            st.setString(6, employee.getName());
            st.setString(7, employee.getSurname());
            st.setString(8, employee.getPosition());

            //Runs the program in SQL Query
            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //Close the connection
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee searchEmployee(String name, String surname) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, dateofbirth, position, employment_year FROM employees WHERE name=?, surname=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, surname);

            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                //Creates new instance of Employee to output it as the result
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("dateofbirth"),
                        rs.getString("position"),
                        rs.getInt("employment_year"));

                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Employee fireEmployee(String name, String surname) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM employees WHERE name=? AND surname=?; DELETE FROM hourstable WHERE name=? AND surname=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, surname);
            st.setString(3, name);
            st.setString(4, surname);

            ResultSet rs = st.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, dateofbirth, position, employment_year FROM employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new LinkedList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("dateofbirth"),
                        rs.getString("position"),
                        rs.getInt("employment_year"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Hours> getHours() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, position, hours FROM hourstable";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Hours> hours = new LinkedList<>();
            while (rs.next()) {
                Hours hour = new Hours(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("hours"));
                hours.add(hour);
            }
            return hours;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getEmployee(String position) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, dateofbirth, position, employment_year FROM employees WHERE position=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, position);

            ResultSet rs = st.executeQuery();
            List<Employee> employees = new LinkedList<>();
            while(rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("dateofbirth"),
                        rs.getString("position"),
                        rs.getInt("employment_year"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean updHours(String name, String surname, double hours) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE hourstable SET hours=? WHERE name=? AND surname=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setDouble(1, hours);
            st.setString(2, name);
            st.setString(3, surname);

            ResultSet rs = st.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
