package model;

public class Student {

    private int id;
    private String name;
    private String department;
    private double cgpa;
    private String email;

    public Student(int id, String name, String department, double cgpa, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getEmail() {
        return email;
    }
}