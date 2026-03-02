package com.college.model;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private String courseName;
    private String duration;
    private String fees;

    public Course() {}

    public Course(String department, String courseName) {
        this.department = department;
        this.courseName = courseName;
        this.duration = "4 Years";
        this.fees = "₹50,000 per year";
    }

    public Long getId() { return id; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getFees() { return fees; }
    public void setFees(String fees) { this.fees = fees; }
}