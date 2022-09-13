package org.example.model;

import java.util.Set;

public class Course {
    private Integer capacity;

    private Set<Student> enrolledStudents;

    public Integer getCapacity() {
        return capacity;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
