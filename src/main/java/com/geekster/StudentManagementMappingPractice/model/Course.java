package com.geekster.StudentManagementMappingPractice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @NotBlank
    private String courseName;

    @NotBlank
    private String courseTitle;


    private String courseDescription;

    private Integer courseDuration;

    //    Mapping Unidirectional
    @ManyToMany
    @JoinTable(name = "fk_course_student_join_table", joinColumns = @JoinColumn(name = "fk_course_id"), inverseJoinColumns = @JoinColumn(name = "fk_student_id"))
    private List<Student> students;
}