package com.springLearning.springLearning.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class StudentResponseDTO {
    private int id;
    private String studentName;
    private String email;
    private int age;
    private String stream;
    List<String> courses;
}
