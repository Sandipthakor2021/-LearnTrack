package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate;
    private EnrollmentStatus status;

    // Parameterized Constructor
    public Enrollment(int id, int studentId, int courseId, String enrollmentDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = EnrollmentStatus.ACTIVE;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    // ===== Business Methods =====

    public void markCompleted() {
        this.status = EnrollmentStatus.COMPLETED;
    }

    public void cancel() {
        this.status = EnrollmentStatus.CANCELLED;
    }

    // ===== Utility (clean output) =====

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", date='" + enrollmentDate + '\'' +
                ", status=" + status +
                '}';
    }
}
