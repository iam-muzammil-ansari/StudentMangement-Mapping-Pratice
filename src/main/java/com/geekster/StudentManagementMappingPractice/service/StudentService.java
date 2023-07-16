package com.geekster.StudentManagementMappingPractice.service;

import com.geekster.StudentManagementMappingPractice.model.Student;
import com.geekster.StudentManagementMappingPractice.model.enums.Branch;
import com.geekster.StudentManagementMappingPractice.model.enums.DeptType;
import com.geekster.StudentManagementMappingPractice.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudent(Student student) {
        iStudentRepo.save(student);
        return "Student Added Successfully!!!";
    }

    public Student getStudentByName(String studentName) {
        return iStudentRepo.findByStudentName(studentName);
    }

    @Transactional
    public String updateStudentInfoByDept(DeptType deptType, Branch branch) {
        Integer countUpdate = iStudentRepo.updateStudentInfoByDept(deptType.name(), branch.name());
        if(countUpdate > 0) {
            return "Student Information updated Successfully!!";
        }else {
            return "Student information not updated because this dept does not exist";
        }
    }

    @Transactional
    public String removeAllStudentsByDept(DeptType deptType) {
        Integer countDelete = iStudentRepo.removeAllStudentsByDept(deptType.name());
        if(countDelete > 0) {
            return "Student Deleted Successfully!!";
        }else {
            return "Student  not deleted because this dept does not exist";
        }
    }
}