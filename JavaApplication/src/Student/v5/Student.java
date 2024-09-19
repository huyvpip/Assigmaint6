package Student.v5;

import java.util.Date;

public class Student extends Person {
    private double gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, double gpa, String major) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.gpa = gpa;
        this.major = major;
    }

    // Getters and Setters
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    // Implementing abstract methods
    @Override
    public void addPerson() {
        // Implementation for adding student
    }

    @Override
    public void updatePerson(String id) {
        // Implementation for updating student by id
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Major: " + getMajor());
        System.out.println("GPA: " + getGpa());
    }
}