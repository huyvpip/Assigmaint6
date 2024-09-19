package Student.v3;
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
            System.out.println("3. Update person");
            System.out.println("4. Delete person by id");
            System.out.println("5. Find person by id");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: {
                    // Thêm sinh viên mới
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    String dobStr = scanner.nextLine();
                    Date dob = new Date(dobStr); // Simple parsing, you'd need to handle exceptions in real code
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
                    // Thêm giáo viên mới
                    System.out.print("Enter Teacher ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    String dobStr = scanner.nextLine();
                    Date dob = new Date(dobStr); // Simple parsing
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
                    // Cập nhật thông tin person
                    System.out.print("Enter Person ID to update: ");
                    String id = scanner.nextLine();
                    Person person = personList.findPersonById(id);
                    if (person != null) {
                        System.out.println("Found person. Enter new details:");
                        System.out.print("Enter Full Name: ");
                        String fullName = scanner.nextLine();
                        person.setFullName(fullName);
                        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                        String dobStr = scanner.nextLine();
                        Date dob = new Date(dobStr); // Simple parsing
                        person.setDateOfBirth(dob);
                        
                        if (person instanceof Student) {
                            Student student = (Student) person;
                            System.out.print("Enter GPA: ");
                            float gpa = scanner.nextFloat();
                            scanner.nextLine(); // Consume newline
                            student.setGpa(gpa);
                            System.out.print("Enter Major: ");
                            String major = scanner.nextLine();
                            student.setMajor(major);
                        } else if (person instanceof Teacher) {
                            Teacher teacher = (Teacher) person;
                            System.out.print("Enter Department: ");
                            String department = scanner.nextLine();
                            teacher.setDepartment(department);
                            System.out.print("Enter Teaching Subject: ");
                            String subject = scanner.nextLine();
                            teacher.setTeachingSubject(subject);
                        }
                        System.out.println("Person updated successfully.");
                    } else {
                        System.out.println("Person not found with ID: " + id);
                    }
                    break;
                }
                case 4: {
                    // Xóa person theo ID
                    System.out.print("Enter Person ID to delete: ");
                    String id = scanner.nextLine();
                    personList.deletePersonById(id);
                    System.out.println("Person deleted if ID was found.");
                    break;
                }
                case 5: {
                    // Tìm kiếm person theo ID
                    System.out.print("Enter Person ID to find: ");
                    String id = scanner.nextLine();
                    Person person = personList.findPersonById(id);
                    if (person != null) {
                        person.displayInfo();
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                }
                case 6: {
                    // Hiển thị tất cả sinh viên và giáo viên
                    personList.displayEveryone();
                    break;
                }
                case 7: {
                    // Tìm sinh viên có GPA cao nhất
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                }
                case 8: {
                    // Tìm giáo viên theo bộ môn
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
                    // Thoát chương trình
                    System.out.println("Exiting...");
                    return;
                }
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
