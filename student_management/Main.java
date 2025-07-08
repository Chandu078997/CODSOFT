import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = getIntInput(scanner);
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    sms.addStudent(new Student(name, roll, grade));
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRoll = getIntInput(scanner);
                    sms.removeStudent(removeRoll);
                    System.out.println("Removed if existed.");
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = getIntInput(scanner);
                    Student found = sms.searchStudent(searchRoll);
                    System.out.println(found != null ? found : "Student not found.");
                    break;

                case 4:
                    sms.displayStudents();
                    break;

                case 5:
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = getIntInput(scanner);
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    sms.updateStudent(updateRoll, newName, newGrade);
                    System.out.println("Updated if student existed.");
                    break;

                case 6:
                    System.out.println("Exiting... Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}

