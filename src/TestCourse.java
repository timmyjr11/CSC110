public class TestCourse {
    public static void main(String[] args) {
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Database Systems");

        course1.addStudent("Peter Jones");
        course1.addStudent("Kim Smith");
        course1.addStudent("Anne Kennedy");

        course2.addStudent("Peter Jones");
        course2.addStudent("Steve Smith");

        System.out.println("Number of students in course1: "
        + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] + ", ");

        System.out.println();
        System.out.print("Number of students in course2: "
        + course2.getNumberOfStudents());
    }
}

class Course {
    private final String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) { this.courseName = courseName; }

    public void addStudent(String Student) {
        students[numberOfStudents] = Student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        // Creates an array with the length of students
        // Then copies all names to return
        String[] studentsInCourse = new String[this.numberOfStudents];
        System.arraycopy(students, 0, studentsInCourse, 0, numberOfStudents);
        return studentsInCourse;
    }

    public int getNumberOfStudents() { return numberOfStudents; }

    public String getCourseName() { return courseName; }

    public void dropStudent(String Student) {
        // Declare a temp array and index for finding the student
        String[] temp = new String[100];
        int index = 0;

        // For loop to match the student name with index
        for (int i = 0; i < numberOfStudents; i++) {
            if (this.students[i].equals(Student)) {
                index = i;
                break;
            }
        }

        // Copy every element but skip the element that had student's name
        System.arraycopy(this.students, 0, temp, 0, index);
        System.arraycopy(this.students, index + 1,
                temp, index,
                this.students.length - index - 1);

        // Reduce student number by one and change reference variable to temp's
        numberOfStudents--;
        this.students = temp;
    }
}