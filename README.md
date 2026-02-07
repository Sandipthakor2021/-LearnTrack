# LearnTrack – Student & Course Management System (Core Java)

LearnTrack is a console-based Student & Course Management System built using Core Java.
The project focuses on practicing Java fundamentals, Object-Oriented Programming (OOP),
collections, exception handling, and clean code principles.

The application allows administrators to manage students, courses, and enrollments
using a menu-driven console interface. All data is stored in-memory using collections.

---

## Features

### Student Management
- Add new students
- View all students
- Deactivate a student (soft delete using active flag)

### Course Management
- Add new courses
- View all courses
- Activate / Deactivate courses

### Enrollment Management
- Enroll a student into a course
- View enrollments for a student
- Mark enrollment as completed or cancelled

---

## Technologies Used
- Java (Core Java)
- ArrayList (for in-memory storage)
- Console-based UI

---

## How to Compile and Run

From the project root directory:

```bash
javac -d out $(find src -name "*.java")
java -cp out com.airtribe.learntrack.Main
