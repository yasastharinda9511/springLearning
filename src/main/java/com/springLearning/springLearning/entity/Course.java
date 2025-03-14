package com.springLearning.springLearning.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "course_name" , nullable = false)
    private String courseName;

    @Column(name = "course_code" , nullable = false, unique =  true)
    private String courseCode;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;


}
