package com.jpa.mappings.instructorAndCity.repository;


import com.jpa.mappings.instructorAndCity.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course,Integer> {


}
