package com.jpa.mappings.instructorAndCity.service;

import com.jpa.mappings.instructorAndCity.entity.Instructor;
import com.jpa.mappings.instructorAndCity.entity.Student;
import com.jpa.mappings.instructorAndCity.repository.InstructorRepository;
import com.jpa.mappings.instructorAndCity.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public  void  save(Instructor instructor){
        instructorRepository.save(instructor);
    }


    public  Instructor findById(int id){
       Optional<Instructor> optional= instructorRepository.findById(id);

       return optional.get();
    }

    @Transactional
    public  void saveStudent(Student student){

        studentRepository.save(student);
    }

}
