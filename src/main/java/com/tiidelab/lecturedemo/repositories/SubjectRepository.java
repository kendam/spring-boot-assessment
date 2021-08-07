package com.tiidelab.lecturedemo.repositories;

import com.tiidelab.lecturedemo.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
