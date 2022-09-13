package org.example.repository;

import org.example.model.Course;

import java.util.Optional;

public interface CourseRepository {
    Optional<Course> findByClassId(final Integer classId);
    void save(final Course course);
}
