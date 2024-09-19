package Student.v5;

import java.util.Date;

public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    // Getters and Setters
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getTeachingSubject() { return teachingSubject; }
    public void setTeachingSubject(String teachingSubject) { this.teachingSubject = teachingSubject; }

    // Implementing abstract methods
    @Override
    public void addPerson() {
        // Implementation for adding teacher
    }

    @Override
    public void updatePerson(String id) {
        // Implementation for updating teacher by id
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Teaching Subject: " + getTeachingSubject());
    }
}
