package Student.v1;
import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    public void updateStudentById(String id, Student updatedStudent) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setFullName(updatedStudent.getFullName());
                student.setDateOfBirth(updatedStudent.getDateOfBirth());
                student.setGpa(updatedStudent.getGpa());
                student.setMajor(updatedStudent.getMajor());
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
        System.out.println("Student removed successfully.");
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentList) {
                student.displayInfo();
            }
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}