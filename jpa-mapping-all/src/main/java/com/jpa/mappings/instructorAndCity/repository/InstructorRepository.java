package com.jpa.mappings.instructorAndCity.repository;

import com.jpa.mappings.instructorAndCity.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer>
{
}
