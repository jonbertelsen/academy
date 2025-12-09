//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {
        public static void main(String[] args) {

            Academy hogwarts = new Academy("Hogwarts");

            hogwarts.enrollStudent(new Student("Harry P"));
            hogwarts.enrollStudent(new Student("Ron W"));
            hogwarts.enrollStudent(new Student("Hermoine"));
            hogwarts.enrollStudent(new Student("Malfoy"));

            hogwarts.printAllStudents();

            hogwarts.addCourse(new Course("Defense Against the Dark Arts"));
            hogwarts.addCourse(new Course("Alchemy"));
            hogwarts.addCourse(new Course("Muggle Studies"));

            hogwarts.printAllCourses();

            hogwarts.registerStudentToCourse("Harry P", "Alchemy", 7);
            hogwarts.registerStudentToCourse("Harry P", "Muggle Studies", 4);
            hogwarts.registerStudentToCourse("Ron W", "Muggle Studies", 10);
            hogwarts.registerStudentToCourse("Hermoine", "Muggle Studies", 12);

            Student s = hogwarts.getStudentByName("Harry P");
            hogwarts.printDiploma(s);
            hogwarts.printDiploma(hogwarts.getStudentByName("Hermoine"));

        }
    }