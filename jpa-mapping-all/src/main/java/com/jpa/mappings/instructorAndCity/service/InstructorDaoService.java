package com.jpa.mappings.instructorAndCity.service;

import com.jpa.mappings.instructorAndCity.entity.Course;
import com.jpa.mappings.instructorAndCity.entity.Instructor;
import com.jpa.mappings.instructorAndCity.entity.InstructorDetail;
import com.jpa.mappings.instructorAndCity.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorDaoService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void save(Instructor instructor){
        entityManager.persist(instructor);
    }

    public  InstructorDetail findInstructorDetailsById(int id){
        return entityManager.find(InstructorDetail.class,id);
    }

    public List<Course> courseList(){
        return  courseRepository.findAll();
    }


}
