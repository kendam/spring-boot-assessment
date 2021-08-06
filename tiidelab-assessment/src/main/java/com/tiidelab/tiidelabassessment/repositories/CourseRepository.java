package com.tiidelab.tiidelabassessment.repositories;

import com.tiidelab.tiidelabassessment.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
