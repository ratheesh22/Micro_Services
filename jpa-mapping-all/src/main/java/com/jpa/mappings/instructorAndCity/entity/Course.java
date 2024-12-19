package com.jpa.mappings.instructorAndCity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "course")
@ToString(exclude = {"instructor","students"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotNull
    @NonNull
    private String title;

    @ManyToOne(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    @NonNull
    private Instructor instructor;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "course_id")
    private List<Review> review;

    @ManyToMany(mappedBy ="courses")
    @JsonIgnore
    private  List<Student> students;
}
