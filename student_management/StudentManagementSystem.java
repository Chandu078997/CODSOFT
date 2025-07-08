import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private final String fileName = "students.dat";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveStudents();
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(s -> s.getRollNumber() == rollNumber);
        saveStudents();
    }

    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) return s;
        }
        return null;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    public void updateStudent(int rollNumber, String newName, String newGrade) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            s.setName(newName);
            s.setGrade(newGrade);
            saveStudents();
        }
    }

    private void saveStudents() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }

    private void loadStudents() {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                students = (List<Student>) in.readObject();
            } catch (Exception e) {
                System.out.println("Error loading students.");
            }
        }
    }
}

