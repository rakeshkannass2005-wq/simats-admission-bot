package com.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.college.model.Course;
import com.college.repository.CourseRepository;
@SpringBootApplication
public class ChatbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(CourseRepository repo) {
        return args -> {

            // Insert only if database is empty
            if (repo.count() == 0) {

                // ================= COMPUTER SCIENCE =================
                repo.save(new Course("Computer Science", "B.Tech CSE"));
                repo.save(new Course("Computer Science", "B.Tech CSE - AI & ML"));
                repo.save(new Course("Computer Science", "B.Tech CSE - Data Science"));
                repo.save(new Course("Computer Science", "B.Tech CSE - Cyber Security"));
                repo.save(new Course("Computer Science", "M.Tech CSE"));

                // ================= MECHANICAL =================
                repo.save(new Course("Mechanical", "B.Tech Mechanical Engineering"));
                repo.save(new Course("Mechanical", "M.Tech Thermal Engineering"));
                repo.save(new Course("Mechanical", "M.Tech CAD/CAM"));

                // ================= ELECTRICAL =================
                repo.save(new Course("Electrical", "B.Tech EEE"));
                repo.save(new Course("Electrical", "M.Tech Power Systems"));

                // ================= ELECTRONICS =================
                repo.save(new Course("Electronics", "B.Tech ECE"));
                repo.save(new Course("Electronics", "B.Tech ECE - VLSI"));
                repo.save(new Course("Electronics", "M.Tech VLSI Design"));

                // ================= CIVIL =================
                repo.save(new Course("Civil", "B.Tech Civil Engineering"));
                repo.save(new Course("Civil", "M.Tech Structural Engineering"));

                // ================= IT =================
                repo.save(new Course("Information Technology", "B.Tech IT"));
                repo.save(new Course("Information Technology", "M.Tech IT"));

                // ================= MBA =================
                repo.save(new Course("Management", "MBA - Finance"));
                repo.save(new Course("Management", "MBA - Marketing"));
                repo.save(new Course("Management", "MBA - HR"));

                // ================= BBA =================
                repo.save(new Course("Management", "BBA"));

                // ================= BCA =================
                repo.save(new Course("Computer Applications", "BCA"));
                repo.save(new Course("Computer Applications", "MCA"));
            }
        };
    }}