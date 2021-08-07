package com.tiidelab.lecturedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "lecturers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturer_id;
    private String first_name;
    private String last_name;

//    @ManyToMany(mappedBy = "lecturers")
//    private List<Lecturer> lecturers;

//    public List<Lecturer> getLecturers() {
//        return lecturers;
//    }
//
//    public void setLecturers(List<Lecturer> lecturers) {
//        this.lecturers = lecturers;
//    }

    public Long getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(Long lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Lecturer() {

    }
}
