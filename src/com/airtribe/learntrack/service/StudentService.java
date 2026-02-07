package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.nextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void deactivateStudent(int id) {
        Student student = studentRepository.findById(id);
        student.deactivate();
    }
}
