import java.util.ArrayList;
import java.util.List;

public class Academy {

    private String name;

    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    List<CourseRegistration> registrations = new ArrayList<>();

    public Academy(String name) {
        this.name = name;
    }

    public void printDiploma(Student student){
        System.out.println("****** Eksamensbevis for " + student.getName() + " ******");
        for (CourseRegistration cr : registrations){
            if (student.getName().equals(cr.getStudent().getName())){
                System.out.println(cr.getCourse().getName() + ": " + cr.getGrade());
            }
        }
    }

    public List<Student> getHighest(int quantity){

        return null;
    }

    public List<Student> getLowest(int quantity){

        return null;
    }

    // ****** Students ************

    public void enrollStudent(Student student){
        students.add(student);
    }

    public void printAllStudents(){
        System.out.println("****** Alle studerende på " + name + " **********");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    // ****** Courses ************

    public void addCourse(Course course){
        courses.add(course);
    }

    public void printAllCourses(){
        System.out.println("****** Alle kurser på " + name + " **********");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }

    // ******** Registrations **************

    public void registerStudentToCourse(Student student, Course course, int grade){
        registrations.add(new CourseRegistration(student, course, grade));
    }

    public void registerStudentToCourse(String studentName, String courseName, int grade){
        Student studentFound = null;
        Course courseFound = null;

        // Find den studerende på Hogwarts, der matcher med studentName

        for (Student s : students){
            if (s.getName().equals(studentName)){
                studentFound = s;
                break;
            }
        }

        // Find det kursus på Hogwarts, der mathcer med courseName
        for (Course c : courses){
            if (c.getName().equals(courseName)){
                courseFound = c;
                break;
            }
        }

        if (studentFound != null && courseFound != null){
            registerStudentToCourse(studentFound, courseFound, grade);
        } else {
            System.out.println("Fejl: Den studerende eller kurset findes ikke");
        }
    }

    public Student getStudentByName(String studentName) {
        for (Student s: students){
            if (s.getName().equals(studentName)){
                return s;
            }
        }
        System.out.println("Kunne ikke finde Student med navn: " + studentName);
        return null;
    }
}
