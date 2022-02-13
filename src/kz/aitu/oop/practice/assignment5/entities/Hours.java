package kz.aitu.oop.practice.assignment5.entities;

public class Hours extends Employee{
    private double hours;

    public Hours() {

    }

    public Hours(String name, String surname, String position, double hours) {
        setName(name);
        setSurname(surname);
        setPosition(position);
        setHours(hours);
    }

    public Hours(int id, String name, String surname, String position, double hours) {
        setId(id);
        setName(name);
        setSurname(surname);
        setPosition(position);
        setHours(hours);
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "Hours{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", hours=" + hours +
                '}' + '\n';
    }
}
