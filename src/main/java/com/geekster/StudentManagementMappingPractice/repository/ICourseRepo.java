package com.geekster.StudentManagementMappingPractice.repository;

import com.geekster.StudentManagementMappingPractice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Integer> {
    @Modifying
    @Query(value = "delete from course where course_duration >= :duration", nativeQuery = true)
    Integer removeAllCoursesByCourseDuration(Integer duration);

    @Modifying
    @Query(value = "update course set course_duration =:duration where course_name = :courseName", nativeQuery = true)
    Integer updateCourseInfoByCourseName(String courseName, Integer duration);
}