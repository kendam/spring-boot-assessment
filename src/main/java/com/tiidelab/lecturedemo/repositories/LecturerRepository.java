package com.tiidelab.lecturedemo.repositories;

import com.tiidelab.lecturedemo.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
}
