
###  **Content**

```md
# Design Notes – LearnTrack

This document explains the key design decisions taken while building the LearnTrack
application and how they align with Core Java best practices.

---

## Why ArrayList instead of Array?

ArrayList was used instead of arrays for storing Students, Courses, and Enrollments because:

- The number of students, courses, and enrollments is dynamic.
- ArrayList automatically resizes as elements are added or removed.
- It provides useful built-in methods like add(), remove(), and iteration support.
- It simplifies code and improves readability compared to managing array sizes manually.

Repositories such as StudentRepository, CourseRepository, and EnrollmentRepository
use ArrayList for in-memory data storage.

---

## Where static members were used and why

Static members were used in the `IdGenerator` utility class.

Reasons:
- ID generation logic is common across the application.
- Static counters ensure unique IDs without creating multiple objects.
- Static methods allow direct access without instantiating the utility class.

Example usage:
- `IdGenerator.nextStudentId()`
- `IdGenerator.nextCourseId()`
- `IdGenerator.nextEnrollmentId()`

This keeps ID management centralized and consistent.

---

## Where inheritance was used and what was gained

Inheritance was implemented using a base class `Person` and a derived class `Student`.

- `Person` contains common fields such as id, firstName, lastName, and email.
- `Student` extends `Person` and adds student-specific fields like batch and active status.

Benefits:
- Code reuse by avoiding duplication of common fields.
- Cleaner and more structured design.
- Demonstrates real-world "is-a" relationship (Student is a Person).
- Enables polymorphism by overriding methods like `getDisplayName()`.

---

## Clean Code Practices Followed

- Methods are small and focused on a single responsibility.
- Meaningful method names are used, such as:
  - `addStudent`
  - `deactivateStudent`
  - `getEnrollmentsByStudent`
- Clear separation of concerns:
  - Entity classes represent data.
  - Repository classes handle storage.
  - Service classes contain business logic.
  - Main class handles user interaction.
- No unused or auto-generated placeholder methods are present.
- Constants are used instead of magic numbers and hardcoded strings.

These practices make the code easy to read, maintain, and extend.
