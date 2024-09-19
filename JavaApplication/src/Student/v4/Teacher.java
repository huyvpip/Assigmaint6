package Student.v4;
import java.util.Date;

public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
        System.out.println("Teacher added: " + fullName);
    }

    @Override
    public void updatePerson(String id) {
        System.out.println("Teacher with ID: " + id + " has been updated.");
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + fullName + ", Department: " + department + ", Subject: " + teachingSubject);
    }
}