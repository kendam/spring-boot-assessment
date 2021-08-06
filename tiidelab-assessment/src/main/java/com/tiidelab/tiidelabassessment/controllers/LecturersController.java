package com.tiidelab.tiidelabassessment.controllers;

import com.tiidelab.tiidelabassessment.models.Course;
import com.tiidelab.tiidelabassessment.models.Lecturer;
import com.tiidelab.tiidelabassessment.repositories.LecturerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecturers")
public class LecturersController {

    @Autowired
    private LecturerRepository lecturerRepository;

    // Get all lecturers
    @GetMapping
    public List<Lecturer> list(){
        return lecturerRepository.findAll();
    }

        
    // get a single lecturer with id
    @GetMapping
    @RequestMapping("{id}")
    public Lecturer get(@PathVariable Long id){
        return lecturerRepository.getById(id);
    }

    // create a new lecturer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lecturer create(@RequestBody final Lecturer lecturer){
        return lecturerRepository.saveAndFlush(lecturer);
    }

    // delete a lecturer
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        lecturerRepository.deleteById(id);
    }


    // update a lecturer
    @RequestMapping(value = "{id}", method = RequestMethod.PUT )
    public Lecturer update(@PathVariable Long id, @RequestBody Lecturer lecturer){
        Lecturer existingLecturer = lecturerRepository.getById(id);
        BeanUtils.copyProperties(lecturer,existingLecturer,"lecturer_id");
        return lecturerRepository.saveAndFlush(existingLecturer);
    }

    // get a single lecturer with id
    @GetMapping
    @RequestMapping("/{id}/courses")
    public List<Course> getCourses(@PathVariable Long id){

        return lecturerRepository.getById(id).getCourses();
    }
}
