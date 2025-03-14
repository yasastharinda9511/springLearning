package com.springLearning.springLearning.mapper;

import com.springLearning.springLearning.dto.response.StudentResponseDTO;
import com.springLearning.springLearning.entity.Student;
import org.modelmapper.ModelMapper;
import com.springLearning.springLearning.entity.Course;


import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static StudentResponseDTO toDto(Student student){

        StudentResponseDTO studentResponseDTO = modelMapper.map(student, StudentResponseDTO.class);

        List<String> courseCodes = student.getCourses()
                .stream()
                .map(Course::getCourseCode)
                .collect(Collectors.toList());

        studentResponseDTO.setCourses(courseCodes);
        return studentResponseDTO;

    }

    public static List<StudentResponseDTO> toDtoList(List<Student> students){
        return students.stream().map(StudentMapper::toDto).collect(Collectors.toList());
    }}
