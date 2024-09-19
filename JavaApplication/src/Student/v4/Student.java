package Student.v4;
import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        System.out.println("Student added: " + fullName);
    }

    @Override
    public void updatePerson(String id) {
        System.out.println("Student with ID: " + id + " has been updated.");
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + fullName + ", GPA: " + gpa + ", Major: " + major);
    }
}
