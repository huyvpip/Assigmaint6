package Student.v5;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        personList.add(student);
    }

    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
    }

    public void updatePerson(String id, Person updatedPerson) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                personList.set(personList.indexOf(person), updatedPerson);
                return;
            }
        }
    }

    public void deletePersonById(String id) {
        personList.removeIf(person -> person.getId().equals(id));
    }


    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        return topStudent;
    }

    public List<Teacher> findTeacherByDepartment(String department) {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }

    public void checkBookBorrowing() {
        for (Person person : personList) {
            if (person.isBookOverdue()) {
                System.out.println("Overdue");
            } else {
                System.out.println("No overdue");
            }
        }
    }

    public void displayEveryone() {
    if (personList == null || personList.isEmpty()) {
        System.out.println("No persons found.");
        return;
    }
}}