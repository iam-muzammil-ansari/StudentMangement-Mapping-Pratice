package com.geekster.StudentManagementMappingPractice.controller;

import com.geekster.StudentManagementMappingPractice.model.Student;
import com.geekster.StudentManagementMappingPractice.model.enums.Branch;
import com.geekster.StudentManagementMappingPractice.model.enums.DeptType;
import com.geekster.StudentManagementMappingPractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

    //    Task -- 1 --> Adding Students --> Create --CR(Crud Repository)
    @PostMapping("student")
    public String addStudent(@RequestBody @Valid Student student) {
        return studentService.addStudent(student);
    }

    //    Task -- 2 --> Getting All Students --> READ/GET --CF(Custom Finder)
    @GetMapping("student")
    public Student getStudentByName(@RequestParam String studentName) {
        return studentService.getStudentByName(studentName);
    }

    //    Task -- 3 --> Update student information by Dept --> Update --CQ(Custom Query)
    @PutMapping("student")
    public String updateStudentInfoByDept(@RequestParam DeptType deptType, @RequestParam Branch branch) {
        return studentService.updateStudentInfoByDept(deptType, branch);
    }

    //    Task -- 4 --> delete all students by Dept --> Delete --CR(Custom Repository)
    @DeleteMapping("students")
    public String removeAllStudentsByDept(@RequestParam DeptType deptType) {
        return studentService.removeAllStudentsByDept(deptType);
    }
}