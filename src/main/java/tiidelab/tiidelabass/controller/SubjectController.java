package tiidelab.tiidelabass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiidelab.tiidelabass.entity.Subject;
import tiidelab.tiidelabass.service.SubjectService;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService service;
    @PostMapping("/api/subject")
    public Subject addSubject(@RequestBody Subject subject){

        return service.saveSubject(subject);
    }
    @PostMapping("/api/subjects")
    public List<Subject> addSubjects(@RequestBody List<Subject> subjects){

        return service.saveSubjects(subjects);
    }

    @GetMapping("/api/subjects")
    public List<Subject> findAllSubjects(){

        return service.getSubjects();

    }
    @GetMapping("/api/subject{id}")
    public Subject findSubjectById(@PathVariable int id){
        return service.getSubjectById(id);
    }
    @GetMapping("/api/subject{name}")
    public Subject findSubjectByName(@PathVariable String name){
        return service.getSubjectByName(name);
    }


    @PutMapping("/api/update")
    public Subject updateSubject(@RequestBody Subject subject){

        return service.updateSubject(subject);
    }

    @DeleteMapping("/api/delete{id}")
    public String deleteSubject(@PathVariable int id){

        return service.deleteSubject(id);


    }
}
