package com.jpa.mappings.instructorAndCity.controller;

import com.jpa.mappings.instructorAndCity.entity.Instructor;
import com.jpa.mappings.instructorAndCity.entity.InstructorDetail;
import com.jpa.mappings.instructorAndCity.entity.Student;
import com.jpa.mappings.instructorAndCity.repository.StudentRepository;
import com.jpa.mappings.instructorAndCity.service.InstructorDaoService;
import com.jpa.mappings.instructorAndCity.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private InstructorDaoService service;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/instructor")
    private ResponseEntity<Boolean> booleanResponseEntity(@Valid @RequestBody Instructor instructor){

        System.out.println(instructor);
        instructorService.save(instructor);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @GetMapping("/instructor_detail/{id}")
    private InstructorDetail instructorDetail(@PathVariable Integer id){
        return  service.findInstructorDetailsById(id.intValue());
    }

    @GetMapping(value = "/instructor/{id}",produces = {"application/xml","application/json"})
    private Instructor instructorGetById(@PathVariable Integer id){
        long startTime=System.currentTimeMillis();
        long endTime=System.currentTimeMillis();

        Instructor ins= instructorService.findById(id.intValue());
        System.out.println(endTime-startTime);
        return  ins;

    }

    @PostMapping("/student")
    private  ResponseEntity<Boolean> createStudent(@RequestBody Student student){

        student.setCourses(service.courseList());

        instructorService.saveStudent(student);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @GetMapping("/student")
    private  ResponseEntity<List<Student>> getStudentsList(){


        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.CREATED);
    }

}
