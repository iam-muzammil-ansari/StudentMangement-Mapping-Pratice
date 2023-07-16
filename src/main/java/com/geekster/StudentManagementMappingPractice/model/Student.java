package com.geekster.StudentManagementMappingPractice.model;

import com.geekster.StudentManagementMappingPractice.model.enums.Branch;
import com.geekster.StudentManagementMappingPractice.model.enums.DeptType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank
    private String studentName;

    @Min(value = 16)
    @Max(value = 50)
    private Integer studentAge;

    @NotBlank
    private String studentPhoneNumber;

    @Enumerated(EnumType.STRING)
    private Branch studentBranch;

    @Enumerated(EnumType.STRING)
    private DeptType studentDepartment;

    //  Mapping unidirectional
    @OneToOne
    @JoinColumn(name = "fk_address_id")
    private Address address;
}