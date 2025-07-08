import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Student Grade Calculator -----");
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        int total = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.print("Invalid! Enter marks between 0 and 100: ");
                marks = sc.nextInt();
            }

            total += marks;
        }

        double average = (double) total / numSubjects;
        char grade;

        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

