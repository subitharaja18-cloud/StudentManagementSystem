import dao.StudentDAO;
import model.Student;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    studentDAO.viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void addStudent() {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Student student = new Student(
                0,
                name,
                department,
                cgpa,
                email
        );

        studentDAO.addStudent(student);
    }

    static void searchStudent() {

        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        studentDAO.searchStudent(id);
    }

    static void updateStudent() {

        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new department: ");
        String department = scanner.nextLine();

        System.out.print("Enter new CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        Student student = new Student(
                id,
                name,
                department,
                cgpa,
                email
        );

        studentDAO.updateStudent(student);
    }

    static void deleteStudent() {

        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        studentDAO.deleteStudent(id);
    }
}