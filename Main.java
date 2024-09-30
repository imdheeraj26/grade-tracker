package studentGrading;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		GradeCalculator gradeCalculator = new GradeCalculator();
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println("Enter student name and grade:"); //type done to finish

		while (true) {
			System.out.print("Enter student name: ");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("done")) {
				break;
			}
			String studentName = input;

			System.out.print("Enter " + studentName + "'s grade: ");
			input = scanner.nextLine();
			try {
				double grade = Double.parseDouble(input);
				gradeCalculator.addStudent(studentName, grade);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid grade.");
			}
		}

		while (true) {
			System.out.println("\nChoose an option:");
			System.out.println("1. View all students and grades");
			System.out.println("2. View average, highest, and lowest grades");
			System.out.println("3. View student rankings");
			System.out.println("4. Update a student's grade");
			System.out.println("5. Remove a student");
			System.out.println("6. View pass/fail results");
			System.out.println("7. Exit");

			input = scanner.nextLine();

			switch (input) {
			case "1":
				gradeCalculator.displayStudentGrades();
				break;
			case "2":
				System.out.println("Average Grade: " + gradeCalculator.calculateAverage());
				System.out.println("Highest Grade: " + gradeCalculator.findHighestGrade());
				System.out.println("Lowest Grade: " + gradeCalculator.findLowestGrade());
				break;
			case "3":
				gradeCalculator.rankStudents();
				break;
			case "4":
				System.out.print("Enter student name to update: ");
				String studentToUpdate = scanner.nextLine();
				System.out.print("Enter new grade: ");
				double newGrade = scanner.nextDouble();
				scanner.nextLine(); // clear buffer
				gradeCalculator.updateStudentGrade(studentToUpdate, newGrade);
				break;
			case "5":
				System.out.print("Enter student name to remove: ");
				String studentToRemove = scanner.nextLine();
				gradeCalculator.removeStudent(studentToRemove);
				break;
			case "6":
				System.out.print("Enter pass mark: ");
				double passMark = scanner.nextDouble();
				scanner.nextLine(); // clear buffer
				gradeCalculator.displayPassFail(passMark);
				break;
			case "7":
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please choose again.");
			}
		}
	}
}
