import java.util.ArrayList;
import java.util.Collections;
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
        System.out.println("Gennemsnit: " + student.getAverageGrade(registrations));
    }

    public List<Student> getHighest(int quantity){
        List<StudentAverageDTO> averageList = new ArrayList<>();
        for (Student s : students){
            StudentAverageDTO studentAverageDTO = new StudentAverageDTO(s, s.getAverageGrade(registrations));
            averageList.add(studentAverageDTO);
        }

        Collections.sort(averageList);

        List<Student> resultList = new ArrayList<>();

        // Hvis quantity er større end antallet af students der har fået karakterer
        if (quantity > averageList.size()){
            quantity = averageList.size();
        }

        for (int i = 0; i < quantity; i++){
            resultList.add(averageList.get(i).getStudent());
        }

       return resultList;
    }

    public List<Student> getLowest(int quantity){
        List<StudentAverageDTO> averageList = new ArrayList<>();
        for (Student s : students){
            StudentAverageDTO studentAverageDTO = new StudentAverageDTO(s, s.getAverageGrade(registrations));
            averageList.add(studentAverageDTO);
        }
        Collections.sort(averageList, Collections.reverseOrder());

        List<Student> resultList = new ArrayList<>();

        // Hvis quantity er større end antallet af students der har fået karakterer
        if (quantity > averageList.size()){
            quantity = averageList.size();
        }

        for (int i = 0; i < quantity; i++){
            resultList.add(averageList.get(i).getStudent());
        }

        return resultList;
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

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<CourseRegistration> getRegistrations() {
        return registrations;
    }
}
