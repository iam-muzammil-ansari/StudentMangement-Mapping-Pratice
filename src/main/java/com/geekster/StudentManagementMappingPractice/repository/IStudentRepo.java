package com.geekster.StudentManagementMappingPractice.repository;

import com.geekster.StudentManagementMappingPractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {

    Student findByStudentName(String studentName);

    @Modifying
    @Query(value = "update student set student_branch = :branch where student_department = :dept", nativeQuery = true)
    Integer updateStudentInfoByDept(String dept, String branch);


    @Modifying
    @Query(value = "Delete from student where student_department = :deptName", nativeQuery = true)
    Integer removeAllStudentsByDept(String deptName);
}

