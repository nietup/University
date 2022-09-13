package org.example.repository;

import org.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(final Integer studentId);
}
