package Student.v5;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by ID");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Check if the book's return due date has arrived");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter Full Name: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        Date dob = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Book Borrow Date (dd/MM/yyyy): ");
                        Date borrowDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Book Return Date (dd/MM/yyyy): ");
                        Date returnDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter GPA: ");
                        double gpa = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Enter Major: ");
                        String major = scanner.nextLine();
                        Student student = new Student(studentId, fullName, dob, borrowDate, returnDate, gpa, major);
                        personList.addStudent(student);
                        System.out.println("Student added successfully!");
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                    }
                    break;

                case 2: 
                    try {
                        System.out.print("Enter Teacher ID: ");
                        String teacherId = scanner.nextLine();
                        System.out.print("Enter Full Name: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        Date dob = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Book Borrow Date (dd/MM/yyyy): ");
                        Date borrowDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Book Return Date (dd/MM/yyyy): ");
                        Date returnDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Teaching Subject: ");
                        String teachingSubject = scanner.nextLine();
                        Teacher teacher = new Teacher(teacherId, fullName, dob, borrowDate, returnDate, department, teachingSubject);
                        personList.addTeacher(teacher);
                        System.out.println("Teacher added successfully!");
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Person ID to update: ");
                    String idToUpdate = scanner.nextLine();
                    
                    break;

                case 4: 
                    System.out.print("Enter Person ID to delete: ");
                    String idToDelete = scanner.nextLine();
                    personList.deletePersonById(idToDelete);
                    System.out.println("Person deleted successfully!");
                    break;

                case 5:
                    personList.displayEveryone();
                    break;

                case 6:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    var teachers = personList.findTeacherByDepartment(department);
                    if (!teachers.isEmpty()) {
                        System.out.println("Teachers in Department " + department + ":");
                        for (Teacher teacher : teachers) {
                            teacher.displayInfo();
                        }
                    } else {
                        System.out.println("No teachers found in that department.");
                    }
                    break;

                case 8: 
                    personList.checkBookBorrowing();
                    break;

                case 0: 
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
        