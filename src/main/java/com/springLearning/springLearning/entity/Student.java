package com.springLearning.springLearning.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="student_name")
    private String studentName;

    private String email;
    private int age;
    private String stream;

    @ManyToMany
    @JoinTable(
            name = "student_courses",  // Join table name
            joinColumns = @JoinColumn(name = "student_id"),  // FK in join table
            inverseJoinColumns = @JoinColumn(name = "course_id")  // FK to course
    )
    private Set<Course> courses;

}
