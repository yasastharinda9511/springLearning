package com.springLearning.springLearning.controller;


import com.springLearning.springLearning.dto.request.CourseRequestDTO;
import com.springLearning.springLearning.dto.response.CourseResponseDTO;
import com.springLearning.springLearning.entity.Course;
import com.springLearning.springLearning.mapper.CourseMapper;
import com.springLearning.springLearning.service.CourseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseController {

    final private CourseService courseService;
    final private ModelMapper modelMapper;
    public CourseController(CourseService courseService, ModelMapper modelMapper) {
        this.courseService = courseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/courses")
    public List<CourseResponseDTO> getAllCourses() {
        return CourseMapper.toDtoList(courseService.getAllCourses());
    }

    @PostMapping("/courses")
    public CourseResponseDTO addCourses(@RequestBody CourseRequestDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        return CourseMapper.toDto(courseService.addCourse(course));
    }
}
