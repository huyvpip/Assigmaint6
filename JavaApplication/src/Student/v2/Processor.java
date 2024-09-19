package Student.v2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Display students with scholarships");
            System.out.println("7. Calculate total tuition of all students");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = sc.nextLine();
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    String dobInput = sc.nextLine();
                    Date dateOfBirth = null;
                    try {
                        dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dobInput);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date as dd/MM/yyyy.");
                        break;
                    }
                    System.out.print("Enter GPA: ");
                    float gpa = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Enter major: ");
                    String major = sc.nextLine();
                    Student student = new Student(id, fullName, dateOfBirth, gpa, major);
                    studentList.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    id = sc.nextLine();
                    System.out.print("Enter new GPA: ");
                    gpa = sc.nextFloat();
                    sc.nextLine(); 
                    System.out.print("Enter new major: ");
                    major = sc.nextLine();
                    studentList.updateStudentById(id, gpa, major);
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    id = sc.nextLine();
                    studentList.deleteStudentById(id);
                    break;
                case 4:
                    studentList.displayAllStudents();
                    break;
                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 6:
                    System.out.println("Students with scholarships:");
                    for (Student s : studentList.findScholarshipStudents()) {
                        s.displayInfo();
                        System.out.println("-------------------------");
                    }
                    break;
                case 7:
                    double totalTuition = studentList.calculateTuitionOfAllStudents();
                    System.out.println("Total tuition of all students: " + totalTuition);
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}