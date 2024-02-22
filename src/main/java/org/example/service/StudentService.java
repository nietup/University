package org.example.service;

import org.example.exception.EntityNotFoundException;
import org.example.model.Course;
import org.example.model.Student;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public StudentService(final CourseRepository courseRepository, final StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    void enroll(final Integer studentId, final Integer courseId) {
        final Course course = courseRepository.findByCourseId(courseId).orElseThrow(EntityNotFoundException::new);
        final int numberOfEnrolled = course.getEnrolledStudents().size();

        if (numberOfEnrolled < course.getCapacity()) {
            final Student student = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
            course.getEnrolledStudents().add(student);
            courseRepository.save(course);
        } else {
            // TODO
        }

    }

    // USEFUL
    private List<Student> getStudentsSortedByGradeAverage(final Set<Student> studentSet) {
        final List<Student> students = new ArrayList<>(studentSet);
        students.sort((s1, s2) -> (int) (s1.getGradeAverage() - s2.getGradeAverage()));
        return students;
    }
}
