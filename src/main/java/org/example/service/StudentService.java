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

    public StudentService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    void enroll(final Integer studentId, final Integer classId) {
        final Course course = courseRepository.findByClassId(classId).orElseThrow(EntityNotFoundException::new);
        int numberOfEnrolled = course.getEnrolledStudents().size();

        if (numberOfEnrolled < course.getCapacity()) {
            Student student = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
            course.getEnrolledStudents().add(student);
            courseRepository.save(course);
        } else {
            // TODO
        }

    }

    // USEFUL
    private List<Student> getStudentsSortedByGradeAverage(final Set<Student> studentSet) {
        List<Student> students = new ArrayList<>(studentSet);
        students.sort((s1, s2) -> (int) (s1.getGradeAverage() - s2.getGradeAverage()));
        return students;
    }
}
