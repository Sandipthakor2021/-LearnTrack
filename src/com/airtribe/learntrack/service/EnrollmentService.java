package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.nextEnrollmentId();
        String date = LocalDate.now().toString();

        Enrollment enrollment = new Enrollment(id, studentId, courseId, date);
        enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public void markEnrollmentCompleted(int enrollmentId) {
        Enrollment e = enrollmentRepository.findById(enrollmentId);
        if (e != null) {
            e.markCompleted();
        }
    }

    public void cancelEnrollment(int enrollmentId) {
        Enrollment e = enrollmentRepository.findById(enrollmentId);
        if (e != null) {
            e.cancel();
        }
    }
}
