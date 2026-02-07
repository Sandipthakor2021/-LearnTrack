package com.airtribe.learntrack.entity;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    // Parameterized Constructor
    public Course(int id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = true;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public boolean isActive() {
        return active;
    }

    // ===== Business Methods =====

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    // ===== Utility (for clean printing) =====

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + courseName + '\'' +
                ", duration=" + durationInWeeks + " weeks" +
                ", active=" + active +
                '}';
    }
}
