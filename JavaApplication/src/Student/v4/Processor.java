package Student.v4;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonList personList = new PersonList();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: {
                    // Add student
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    String dobStr = scanner.nextLine();
                    Date dob = new Date(dobStr);
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    
                    Student student = new Student(id, fullName, dob, gpa, major);
                    personList.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                }
                case 2: {
                    // Add teacher
                    System.out.print("Enter Teacher ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    String dobStr = scanner.nextLine();
                    Date dob = new Date(dobStr);
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Teaching Subject: ");
                    String subject = scanner.nextLine();
                    
                    Teacher teacher = new Teacher(id, fullName, dob, department, subject);
                    personList.addTeacher(teacher);
                    System.out.println("Teacher added successfully.");
                    break;
                }
                case 3: {
                    // Update person by ID
                    System.out.print("Enter Person ID to update: ");
                    String id = scanner.nextLine();
                    personList.updatePerson(id);
                    break;
                }
                case 4: {
                    // Delete person by ID
                    System.out.print("Enter Person ID to delete: ");
                    String id = scanner.nextLine();
                    personList.deletePersonById(id);
                    System.out.println("Person deleted if ID was found.");
                    break;
                }
                case 5: {
                    // Display all persons
                    personList.displayEveryone();
                    break;
                }
                case 6: {
                    // Find top student
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                }
                case 7: {
                    // Find teacher by department
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Teacher teacher = personList.findTeacherByDepartment(department);
                    if (teacher != null) {
                        System.out.println("Teacher in department " + department + ":");
                        teacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in department: " + department);
                    }
                    break;
                }
                case 0: {
                    // Exit
                    System.out.println("Exiting...");
                    return;
                }
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}

