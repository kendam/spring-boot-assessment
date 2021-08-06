package tiidelab.tiidelabass.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiidelab.tiidelabass.repository.SubjectRepository;
import tiidelab.tiidelabass.entity.Subject;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Subject saveSubject(Subject subject){
       return  repository.save(subject);


    }

    public List<Subject> saveSubjects(List<Subject> subjects){
        return  repository.saveAll(subjects);


    }
    public List<Subject> getSubjects(List<Subject> subjects){


        return repository.findAll();

    }
    public Subject getSubjectById(int id){

        return repository.findById(id).orElse(null);

    }

    public Subject getSubjectByName(String name) {
        return repository.findByName(name);
    }

    public String deleteSubject(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Subject updateSubject(Subject subject) {
        Subject existingSubject = repository.findById(subject.getId()).orElse(null);
        existingSubject.setName(subject.getName());
        return repository.save(existingSubject);
    }


    public List<Subject> getSubject(List<Subject> subject) {

        return subject;
    }

    public List<Subject> getSubjects() {
        return null;
    }
}
