package com.geekster.StudentManagementMappingPractice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @NotBlank
    private String bookName;

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String bookAuthor;


    private String bookDescription;

    private Integer bookPrice;

    //Mapping
    @ManyToOne
    @JoinColumn(name = "fk_student_id")
    private Student student;
}