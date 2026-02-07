package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course with ID " + id + " not found");
    }
}
