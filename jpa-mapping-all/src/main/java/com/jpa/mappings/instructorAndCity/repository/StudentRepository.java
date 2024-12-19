package com.jpa.mappings.instructorAndCity.repository;

import com.jpa.mappings.instructorAndCity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
