package classroommanager;

import java.util.Scanner;

import classroommanager.services.AssignmentService;
import classroommanager.services.ClassroomService;
import classroommanager.services.StudentService;

public class ClassroomManagerApp {

    private static ClassroomService classroomService = new ClassroomService();
    private static StudentService studentService = new StudentService(classroomService);
    private static AssignmentService assignmentService = new AssignmentService(classroomService);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleAddClassroom(scanner);
                    break;
                case "2":
                    handleAddStudent(scanner);
                    break;
                case "3":
                    handleScheduleAssignment(scanner);
                    break;
                case "4":
                    handleSubmitAssignment(scanner);
                    break;
                case "5":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Classroom");
        System.out.println("2. Add Student");
        System.out.println("3. Schedule Assignment");
        System.out.println("4. Submit Assignment");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleAddClassroom(Scanner scanner) {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine().trim();

        if (className.isEmpty()) {
            System.out.println("Class name cannot be empty.");
            return;
        }

        classroomService.addClassroom(className);
    }

    private static void handleAddStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter class name: ");
        String className = scanner.nextLine().trim();

        if (studentId.isEmpty() || className.isEmpty()) {
            System.out.println("Student ID and Class name cannot be empty.");
            return;
        }

        studentService.addStudent(studentId, className);
    }

    private static void handleScheduleAssignment(Scanner scanner) {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine().trim();

        System.out.print("Enter assignment details: ");
        String assignmentDetails = scanner.nextLine().trim();

        if (className.isEmpty() || assignmentDetails.isEmpty()) {
            System.out.println("Class name and Assignment details cannot be empty.");
            return;
        }

        assignmentService.scheduleAssignment(className, assignmentDetails);
    }

    private static void handleSubmitAssignment(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter class name: ");
        String className = scanner.nextLine().trim();

        System.out.print("Enter assignment details: ");
        String assignmentDetails = scanner.nextLine().trim();

        if (studentId.isEmpty() || className.isEmpty() || assignmentDetails.isEmpty()) {
            System.out.println("Student ID, Class name, and Assignment details cannot be empty.");
            return;
        }

        assignmentService.submitAssignment(studentId, className, assignmentDetails);
    }
}
