package com.college.repository;

import com.college.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByDepartmentIgnoreCase(String department);

}