import java.util.List;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + '}';
    }

    // en kursustilmelding består af: (Student, Course, grade)

    public double getAverageGrade(List<CourseRegistration> registrations){
        int i = 0;
        double sumOfGrades = 0;
        for (CourseRegistration cr : registrations){
            if (this.getName().equals(cr.getStudent().getName())){
                sumOfGrades += cr.getGrade();
                i++;
            }
        }
        if (sumOfGrades > 0){
            return sumOfGrades / i;
        } else {
            return 0;
        }

    }


}
