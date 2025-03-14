package com.springLearning.springLearning.repository;

import com.springLearning.springLearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c WHERE c.courseCode IN:courseCodes")
    List<Course> findByCourseCodes(@Param("courseCodes") List<String> courseCodes);
}
