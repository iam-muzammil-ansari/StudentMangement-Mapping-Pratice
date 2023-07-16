package com.geekster.StudentManagementMappingPractice.model;

import com.geekster.StudentManagementMappingPractice.model.enums.Brand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer laptopId;

    @NotBlank
    private String laptopName;

    @Enumerated(EnumType.STRING)
    private Brand laptopBrand;

    private Integer laptopPrice;

    //  Mapping unidirectional
    @OneToOne
    @JoinColumn(name = "fk_student_id")
    private Student student;
}