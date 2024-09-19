package Student.v2;
import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void updateStudentById(String id, float gpa, String major) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setGpa(gpa);
                student.setMajor(major);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
        System.out.println("Student deleted successfully!");
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("-------------------------");
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

    public ArrayList<Student> findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.isScholarship()) {
                scholarshipStudents.add(student);
            }
        }
        return scholarshipStudents;
    }

    public double calculateTuitionOfAllStudents() {
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.getTuition();
        }
        return totalTuition;
    }
}