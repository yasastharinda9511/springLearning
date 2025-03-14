package com.springLearning.springLearning.dto.response;

import com.springLearning.springLearning.entity.Course;
import com.springLearning.springLearning.repository.CourseRepository;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponseDTO {
    private int id;
    private String courseName;
    private String courseCode;

}
