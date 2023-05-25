package org.example.repository;

import org.example.model.Course;

import java.util.Optional;

public interface CourseRepository {
    Optional<Course> findByCourseId(final Integer courseId);
    void save(final Course course);
}
