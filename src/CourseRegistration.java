public class CourseRegistration {

    private Student student;
    private Course course;
    private int grade;

    public CourseRegistration(Student student, Course course, int grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }



    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "CourseRegistration{" + "student=" + student + ", course=" + course + ", grade=" + grade + '}';
    }
}
