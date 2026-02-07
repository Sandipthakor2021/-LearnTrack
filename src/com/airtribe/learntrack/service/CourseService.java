package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {

    private CourseRepository courseRepository = new CourseRepository();

    public void addCourse(String name, String description, int durationInWeeks) {
        int id = IdGenerator.nextCourseId();
        Course course = new Course(id, name, description, durationInWeeks);
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deactivateCourse(int id) {
        Course course = courseRepository.findById(id);
        course.deactivate();
    }
}
