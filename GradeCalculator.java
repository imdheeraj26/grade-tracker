package studentGrading;
import java.util.ArrayList;
import java.util.Comparator;
class GradeCalculator {
    private ArrayList<Student> students;

    public GradeCalculator() {
        students = new ArrayList<>();
    }

                                                                 // Add student and grade
    public void addStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }

                                                                   // Update student's grade
    public void updateStudentGrade(String name, double newGrade) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.setGrade(newGrade);
                System.out.println("Updated " + name + "'s grade to " + newGrade);
                return;
            }
        }
        System.out.println("Student not found.");
    }

                                                                           // Remove a student
    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equalsIgnoreCase(name));
        System.out.println("Removed student: " + name);
    }

                                                                           // Calculate average
    public double calculateAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }

                                                                           // Find highest grade
    public double findHighestGrade() {
        return students.stream().mapToDouble(Student::getGrade).max().orElse(0);
    }

                                                                             // Find lowest grade
    public double findLowestGrade() {
        return students.stream().mapToDouble(Student::getGrade).min().orElse(0);
    }

                                                       // Display grade categories (e.g., A, B, C)
    public String getGradeCategory(double grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

                                                         // Display students who passed or failed
    public void displayPassFail(double passMark) {
        System.out.println("\nPass/Fail Results:");
        for (Student student : students) {
            if (student.getGrade() >= passMark) {
                System.out.println(student.getName() + " passed with grade: " + student.getGrade());
            } else {
                System.out.println(student.getName() + " failed with grade: " + student.getGrade());
            }
        }
    }

                                              // Rank students based on grades (highest to lowest)
    public void rankStudents() {
        System.out.println("\nStudent Rankings:");
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student.getName() + " - Grade: " + student.getGrade() + " (" + getGradeCategory(student.getGrade()) + ")");
        }
    }

                                                                // Display all students and grades
    public void displayStudentGrades() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
        } else {
            for (Student student : students) {
                System.out.println("Student: " + student.getName() + ", Grade: " + student.getGrade() + " (" + getGradeCategory(student.getGrade()) + ")");
            }
        }
    }
}

