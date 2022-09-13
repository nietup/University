package org.example.model;

import java.util.Set;

public class Student {
    private Double gradeAverage;

    private Set<Course> courses;

    public Double getGradeAverage() {
        return gradeAverage;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
