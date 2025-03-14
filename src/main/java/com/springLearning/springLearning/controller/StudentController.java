package com.springLearning.springLearning.controller;

import com.springLearning.springLearning.dto.request.EnrollRequestDTO;
import com.springLearning.springLearning.dto.response.CourseResponseDTO;
import com.springLearning.springLearning.dto.response.StudentResponseDTO;
import com.springLearning.springLearning.entity.Course;
import com.springLearning.springLearning.entity.Student;
import com.springLearning.springLearning.mapper.StudentMapper;
import com.springLearning.springLearning.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private final StudentService studentService;
    private final ModelMapper modelMapper;

    public StudentController(StudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents() {
        return StudentMapper.toDtoList( studentService.getAllStudents());
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@RequestBody Student student) {
        return StudentMapper.toDto( studentService.saveStudent(student));
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO getStudentById(@PathVariable("student-id") Integer id) {
        return StudentMapper.toDto(studentService.getStudentById(id));
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDTO> getStudentByStudentName(@PathVariable("student-name") String studentName) {
        return StudentMapper.toDtoList(studentService.getStudentByStudentName(studentName));
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer id
    ) {
        studentService.deleteStudentById(id);
    }


    @PostMapping("students/{student-id}/enroll")
    public StudentResponseDTO enrollStudentInCourses(
            @PathVariable("student-id") Integer studentId,
            @RequestBody EnrollRequestDTO enrollRequestDTO) {
        return StudentMapper.toDto(studentService.enrollStudentInCourses(studentId, enrollRequestDTO.getCourseIds()));
    }

}
