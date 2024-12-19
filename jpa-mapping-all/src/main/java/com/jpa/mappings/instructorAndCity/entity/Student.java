package com.jpa.mappings.instructorAndCity.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "student")
@JacksonXmlRootElement(localName = "Instructor")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "first_name")
    @NonNull
    @NotNull
    @Pattern(regexp = "^(?=.*\\S).+$")
    private String firstName;
    @Column(name = "last_name")
    @NonNull
    @NotNull
    @Pattern(regexp = "^(?=.*\\S).+$")
    private String lastName;

    @Column(name = "email",unique = true)
    @NonNull
    @NotNull
    @Email
    private String email;

    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns =  @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private  List<Course> courses;



}

