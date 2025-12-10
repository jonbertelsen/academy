public class StudentAverageDTO implements Comparable<StudentAverageDTO> {
    private Student student;
    private double average;

    public StudentAverageDTO(Student student, double average) {
        this.student = student;
        this.average = average;
    }

    public Student getStudent() {
        return student;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public int compareTo(StudentAverageDTO o) {
        if (this.average > o.average){
            return 1;
        } else {
            if (this.average < o.average){
                return -1;
            }
        }
        return 0;
    }
}
