package com.springLearning.springLearning.repository;

import com.springLearning.springLearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByStudentNameContaining(String firstName);
}
