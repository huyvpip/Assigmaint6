package Student.v3;

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
    public void displayInfo() {
        System.out.println("Teacher ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }

    public void updateTeacher(String id) {
        
    }
}
                                                                          