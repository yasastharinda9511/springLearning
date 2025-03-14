package com.springLearning.springLearning.service;

import com.springLearning.springLearning.entity.Course;
import com.springLearning.springLearning.entity.Student;
import com.springLearning.springLearning.repository.CourseRepository;
import com.springLearning.springLearning.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentByStudentName(String studentName) {
        return studentRepository.findAllByStudentNameContaining(studentName);
    }

    public void deleteStudentById(
            Integer id
    ){
        studentRepository.deleteById(id);
    }

    public Student enrollStudentInCourses(int studentId, List<String> courseIds) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Set<Course> courses = new HashSet<>(courseRepository.findByCourseCodes(courseIds));

        student.getCourses().addAll(courses);  // Add courses to student

        return studentRepository.save(student);  // Save updated student with courses
    }
}
