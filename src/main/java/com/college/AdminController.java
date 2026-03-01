package com.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.college.model.Course;
import com.college.repository.CourseRepository;

@Controller
public class AdminController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "admin";
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestParam String department,
                            @RequestParam String courseName,
                            @RequestParam String duration,
                            @RequestParam String fees) {

        Course course = new Course();
        course.setDepartment(department);
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setFees(fees);

        courseRepository.save(course);

        return "redirect:/admin";
    }
}