package Student.v2;

import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;
    private double tuition;
    private boolean scholarship;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.tuition = calculateTuition();
        this.scholarship = gpa >= 9.0;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.tuition = calculateTuition();  
        this.scholarship = gpa >= 9.0;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public double calculateTuition() {
        double baseTuition = 10000000;  
        if (gpa >= 9.0) {
            return baseTuition * 0.5;   
        } else {
            return baseTuition;
        }
    }

    
    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Tuition: " + tuition);
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }
}