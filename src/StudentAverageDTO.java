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
        return Double.compare(this.average, o.average);
    }
}
