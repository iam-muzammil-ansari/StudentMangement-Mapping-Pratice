package com.geekster.StudentManagementMappingPractice.service;

import com.geekster.StudentManagementMappingPractice.model.Course;
import com.geekster.StudentManagementMappingPractice.repository.ICourseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    ICourseRepo iCourseRepo;

    public String addCourse(Course course) {
        iCourseRepo.save(course);
        return "Course Added Successfully!!!";
    }


    public Course getCourseByCourseId(Integer courseId) {
        return iCourseRepo.findById(courseId).orElse(null);
    }

    @Transactional
    public String updateCourseInfoByCourseName(String courseName, Integer duration) {
        Integer countUpdate = iCourseRepo.updateCourseInfoByCourseName(courseName, duration);
        if(countUpdate > 0) {
            return "Course Information updated Successfully!!";
        }else {
            return "Course information not updated because this Course name does not exist";
        }
    }

    @Transactional
    public String removeAllCoursesByCourseDuration(Integer duration) {
        Integer countDelete = iCourseRepo.removeAllCoursesByCourseDuration(duration);
        if(countDelete > 0) {
            return "Courses Deleted Successfully!!";
        }else {
            return "Courses not deleted because this Duration range does not exist";
        }
    }
}