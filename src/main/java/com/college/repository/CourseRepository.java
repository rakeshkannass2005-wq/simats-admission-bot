package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.model.Course;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByDepartmentIgnoreCase(String department);
}