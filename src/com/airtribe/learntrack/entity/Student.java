package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String batch;
    private boolean active;

    // Constructor with email
    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    // Constructor overloading (without email)
    public Student(int id, String firstName, String lastName, String batch) {
        this(id, firstName, lastName, null, batch);
    }

    // ===== Getters =====

    public String getBatch() {
        return batch;
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

    // ===== Polymorphism =====

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " | Batch: " + batch;
    }

    // ===== Utility =====

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + firstName + " " + lastName + '\'' +
                ", batch='" + batch + '\'' +
                ", active=" + active +
                '}';
    }
}
