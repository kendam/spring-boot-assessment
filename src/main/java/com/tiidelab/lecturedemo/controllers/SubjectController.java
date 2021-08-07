package com.tiidelab.lecturedemo.controllers;

import com.tiidelab.lecturedemo.models.Subject;
import com.tiidelab.lecturedemo.repositories.SubjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subjects")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> list() {
        return subjectRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Subject get(@PathVariable Long id) {
        return subjectRepository.getById(id);
    }

    @PostMapping
    public Subject create(@RequestBody final Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Subject update(@PathVariable Long id, @RequestBody Subject subject) {
        Subject existingSubject = subjectRepository.getById(id);
        BeanUtils.copyProperties(subject, existingSubject, "subject_id", "subject_lecturer");
        return subjectRepository.saveAndFlush(existingSubject);
    }
}
