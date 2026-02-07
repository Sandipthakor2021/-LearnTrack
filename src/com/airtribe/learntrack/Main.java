package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {

        boolean running = true;
        System.out.println(AppConstants.APP_WELCOME);

        while (running) {
            try {
                printMainMenu();
                int choice = readInt();

                switch (choice) {
                    case MenuOptions.STUDENT_MANAGEMENT:
                        handleStudentMenu();
                        break;

                    case MenuOptions.COURSE_MANAGEMENT:
                        handleCourseMenu();
                        break;

                    case MenuOptions.ENROLLMENT_MANAGEMENT:
                        handleEnrollmentMenu();
                        break;

                    case MenuOptions.EXIT:
                        running = false;
                        System.out.println(AppConstants.APP_EXIT);
                        break;

                    default:
                        System.out.println(AppConstants.INVALID_OPTION);
                }

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }

    // ===================== MENUS =====================

    private static void printMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void handleStudentMenu() {
        System.out.println("\nStudent Management");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Deactivate Student");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");

        int choice = readInt();

        switch (choice) {
            case MenuOptions.ADD_STUDENT:
                addStudentFlow();
                break;

            case MenuOptions.VIEW_STUDENTS:
                studentService.getAllStudents()
                        .forEach(s -> System.out.println(s.getDisplayName()));
                break;

            case MenuOptions.DEACTIVATE_STUDENT:
                System.out.print("Enter Student ID: ");
                int id = readInt();
                studentService.deactivateStudent(id);
                System.out.println("Student deactivated.");
                break;

            case MenuOptions.EXIT:
                return;

            default:
                System.out.println(AppConstants.INVALID_OPTION);
        }
    }

    private static void handleCourseMenu() {
        System.out.println("\nCourse Management");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");

        int choice = readInt();

        switch (choice) {
            case MenuOptions.ADD_COURSE:
                addCourseFlow();
                break;

            case MenuOptions.VIEW_COURSES:
                courseService.getAllCourses()
                        .forEach(c -> System.out.println(c.getCourseName()));
                break;

            case MenuOptions.EXIT:
                return;

            default:
                System.out.println(AppConstants.INVALID_OPTION);
        }
    }

    private static void handleEnrollmentMenu() {
        System.out.println("\nEnrollment Management");
        System.out.println("1. Enroll Student in Course");
        System.out.println("2. View Enrollments for Student");
        System.out.println("3. Mark Enrollment Completed");
        System.out.println("4. Cancel Enrollment");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");

        int choice = readInt();

        switch (choice) {
            case MenuOptions.ENROLL_STUDENT:
                System.out.print("Student ID: ");
                int studentId = readInt();
                System.out.print("Course ID: ");
                int courseId = readInt();
                enrollmentService.enrollStudent(studentId, courseId);
                System.out.println(AppConstants.ENROLLMENT_SUCCESS);
                break;

            case MenuOptions.VIEW_ENROLLMENTS:
                System.out.print("Student ID: ");
                int sid = readInt();
                enrollmentService.getEnrollmentsByStudent(sid)
                        .forEach(e -> System.out.println(
                                "Enrollment ID: " + e.getId() +
                                ", Course ID: " + e.getCourseId() +
                                ", Status: " + e.getStatus()
                        ));
                break;

            case MenuOptions.COMPLETE_ENROLLMENT:
                System.out.print("Enrollment ID: ");
                enrollmentService.markEnrollmentCompleted(readInt());
                System.out.println("Enrollment marked as completed.");
                break;

            case MenuOptions.CANCEL_ENROLLMENT:
                System.out.print("Enrollment ID: ");
                enrollmentService.cancelEnrollment(readInt());
                System.out.println("Enrollment cancelled.");
                break;

            case MenuOptions.EXIT:
                return;

            default:
                System.out.println(AppConstants.INVALID_OPTION);
        }
    }

    // ===================== FLOWS =====================

    private static void addStudentFlow() {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        studentService.addStudent(firstName, lastName, email, batch);
        System.out.println(AppConstants.STUDENT_ADDED);
    }

    private static void addCourseFlow() {
        System.out.print("Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Duration (weeks): ");
        int duration = readInt();

        courseService.addCourse(name, description, duration);
        System.out.println(AppConstants.COURSE_ADDED);
    }

    // ===================== INPUT =====================

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                    "Invalid number input. Please enter a valid number."
            );
        }
    }
}
