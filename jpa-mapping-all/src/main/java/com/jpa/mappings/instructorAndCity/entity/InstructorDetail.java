package com.jpa.mappings.instructorAndCity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "instructor_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "youtube_channel",unique = true)
    @NonNull
    @NotNull
    @Pattern(regexp = "^(?=.*\\S).+$")
    private String youtubeChannel;
    @Column(name = "hobby")
    @NonNull
    @NotNull
    private String hobby;

    //Bidirectional
    //@NotNull
    //@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    //private Instructor instructor;
}
