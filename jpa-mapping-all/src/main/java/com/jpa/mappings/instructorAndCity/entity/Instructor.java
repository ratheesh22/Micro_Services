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
@Table(name = "instructor")
@JacksonXmlRootElement(localName = "Instructor")
public class Instructor {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="instructor_detail_id")
    @NotNull
    private  InstructorDetail instructorDetail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor" ,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
    private List<Course> courses;
}
