package com.tiidelab.tiidelabassessment.controllers;

import com.tiidelab.tiidelabassessment.models.Course;
import com.tiidelab.tiidelabassessment.models.Lecturer;
import com.tiidelab.tiidelabassessment.repositories.CourseRepository;
import com.tiidelab.tiidelabassessment.repositories.LecturerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Course get(@PathVariable Long id){
        return courseRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody final Course course){
        return courseRepository.saveAndFlush(course);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        courseRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Course update(@PathVariable Long id, @RequestBody Course course){
        Course existingCourse = courseRepository.getById(id);
        BeanUtils.copyProperties(course, existingCourse, "course_id");
        return courseRepository.saveAndFlush(existingCourse);
    }



    // task solution lies here
    @RequestMapping(value = "/{course_id}/lecturer/{lecturer_id}/assign", method = RequestMethod.PUT)
    public Course assignLecturerToCourse(
            @PathVariable Long course_id,
            @PathVariable Long lecturer_id
        ){

        Course course = courseRepository.getById(course_id);
        Lecturer lecturer = lecturerRepository.getById(lecturer_id);

        course.assignLecturer(lecturer);

        return courseRepository.saveAndFlush(course);

    }
}
