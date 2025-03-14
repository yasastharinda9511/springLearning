package com.springLearning.springLearning.mapper;

import com.springLearning.springLearning.dto.response.CourseResponseDTO;
import com.springLearning.springLearning.entity.Course;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    private static final ModelMapper courseMapper = new ModelMapper();

    public static CourseResponseDTO toDto(Course course){
        return courseMapper.map(course, CourseResponseDTO.class);
    }

    public static List<CourseResponseDTO> toDtoList(List<Course> courses){
        return courses.stream().map(CourseMapper::toDto).collect(Collectors.toList());
    }
}
