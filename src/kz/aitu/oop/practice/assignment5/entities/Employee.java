package kz.aitu.oop.practice.assignment5.entities;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String position;
    private int employmentYear;

    public Employee() {

    }

    public Employee(String name, String surname, String dateOfBirth, String position, int employmentYear) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setPosition(position);
        setEmploymentYear(employmentYear);
    }

    public Employee(int id, String name, String surname, String dateOfBirth, String position, int employmentYear) {
        setId(id);
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setPosition(position);
        setEmploymentYear(employmentYear);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date of birth='" + dateOfBirth + '\'' +
                ", position='" + position + '\'' +
                ", employment year=" + employmentYear +
                '}' + '\n';
    }
}
