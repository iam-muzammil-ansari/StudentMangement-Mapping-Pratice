package com.geekster.StudentManagementMappingPractice.controller;


import com.geekster.StudentManagementMappingPractice.model.Course;
import com.geekster.StudentManagementMappingPractice.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    //    Task -- 1 --> Adding Course --> Create --CR(Crud Repository)
    @PostMapping("course")
    public String addCourse(@RequestBody @Valid Course course) {
        return courseService.addCourse(course);
    }

    //    Task -- 2 --> Getting  Course --> READ/GET --CR(Custom Repository)
    @GetMapping("course")
    public Course getCourseByCourseId(@RequestParam Integer courseId) {
        return courseService.getCourseByCourseId(courseId);
    }

    //    Task -- 3 --> Update Course information by course name --> Update --CQ(Custom Query)
    @PutMapping("course")
    public String updateCourseInfoByCourseName(@RequestParam String courseName, @RequestParam Integer duration) {
        return courseService.updateCourseInfoByCourseName(courseName, duration);
    }

    //    Task -- 4 --> delete all Course by CourseDuration --> Delete --CR(Custom Query)
    @DeleteMapping("courses")
    public String removeAllCoursesByCourseDuration(@RequestParam Integer duration) {
        return courseService.removeAllCoursesByCourseDuration(duration);
    }

}
