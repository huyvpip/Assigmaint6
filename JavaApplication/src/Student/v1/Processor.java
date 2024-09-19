package Student.v1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter Full Name:");
                    String fullName = scanner.nextLine();
                    System.out.println("Enter Date of Birth (dd/MM/yyyy):");
                    String dobStr = scanner.nextLine();
                    Date dateOfBirth = null;
                    try {
                        dateOfBirth = dateFormat.parse(dobStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                        break;
                    }
                    System.out.println("Enter GPA:");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Major:");
                    String major = scanner.nextLine();
                    studentList.addStudent(new Student(id, fullName, dateOfBirth, gpa, major));
                    break;

                case 2:
                    System.out.println("Enter Student ID to update:");
                    String updateId = scanner.nextLine();
                    System.out.println("Enter New Full Name:");
                    String newFullName = scanner.nextLine();
                    System.out.println("Enter New Date of Birth (dd/MM/yyyy):");
                    String newDobStr = scanner.nextLine();
                    Date newDateOfBirth = null;
                    try {
                        newDateOfBirth = dateFormat.parse(newDobStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                        break;
                    }
                    System.out.println("Enter New GPA:");
                    float newGpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Enter New Major:");
                    String newMajor = scanner.nextLine();
                    studentList.updateStudentById(updateId, new Student(updateId, newFullName, newDateOfBirth, newGpa, newMajor));
                    break;

                case 3:
                    System.out.println("Enter Student ID to delete:");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}