package com.tiidelab.lecturedemo.controllers;

import com.tiidelab.lecturedemo.models.Lecturer;
import com.tiidelab.lecturedemo.models.Subject;
import com.tiidelab.lecturedemo.repositories.LecturerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lecturers")
public class LecturerController {

    @Autowired
    private LecturerRepository lecturerRepository;

    @GetMapping
    public List<Lecturer> list() {
        return lecturerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Lecturer get(@PathVariable Long id) {
        return lecturerRepository.getById(id);
    }

    @PostMapping
    public Lecturer create(@RequestBody final Lecturer lecturer) {
        return lecturerRepository.saveAndFlush(lecturer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        lecturerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Lecturer update(@PathVariable Long id, @RequestBody Lecturer lecturer) {
        Lecturer existingLecturer = lecturerRepository.getById(id);
        BeanUtils.copyProperties(lecturer, existingLecturer, "lecturer_id");
        return lecturerRepository.saveAndFlush(existingLecturer);
    }
}
