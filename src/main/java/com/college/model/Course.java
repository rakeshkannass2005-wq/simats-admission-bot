package com.college.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String department;
    private String courseName;
    private String duration;
    private String fees;

    // Getters
    public int getId() { return id; }
    public String getDepartment() { return department; }
    public String getCourseName() { return courseName; }
    public String getDuration() { return duration; }
    public String getFees() { return fees; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setDepartment(String department) { this.department = department; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setFees(String fees) { this.fees = fees; }
}