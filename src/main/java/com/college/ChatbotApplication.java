package com.college;

import com.college.User;
import com.college.UserRepository;
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
    CommandLineRunner loadData(CourseRepository repo, UserRepository userRepo) {
        return args -> {

            // Create default admin if not exists
            if (userRepo.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setRole("ADMIN");
                userRepo.save(admin);
            }  // ✅ CLOSED HERE

            // Insert only if database is empty
            if (repo.count() == 0) {

                repo.save(new Course("Computer Science", "B.Tech CSE"));
                repo.save(new Course("Computer Science", "B.Tech CSE - AI & ML"));
                repo.save(new Course("Computer Science", "B.Tech CSE - Data Science"));
                repo.save(new Course("Computer Science", "B.Tech CSE - Cyber Security"));
                repo.save(new Course("Computer Science", "M.Tech CSE"));

                repo.save(new Course("Mechanical", "B.Tech Mechanical Engineering"));
                repo.save(new Course("Mechanical", "M.Tech Thermal Engineering"));
                repo.save(new Course("Mechanical", "M.Tech CAD/CAM"));

                repo.save(new Course("Electrical", "B.Tech EEE"));
                repo.save(new Course("Electrical", "M.Tech Power Systems"));

                repo.save(new Course("Electronics", "B.Tech ECE"));
                repo.save(new Course("Electronics", "B.Tech ECE - VLSI"));
                repo.save(new Course("Electronics", "M.Tech VLSI Design"));

                repo.save(new Course("Civil", "B.Tech Civil Engineering"));
                repo.save(new Course("Civil", "M.Tech Structural Engineering"));

                repo.save(new Course("Information Technology", "B.Tech IT"));
                repo.save(new Course("Information Technology", "M.Tech IT"));

                repo.save(new Course("Management", "MBA - Finance"));
                repo.save(new Course("Management", "MBA - Marketing"));
                repo.save(new Course("Management", "MBA - HR"));

                repo.save(new Course("Management", "BBA"));

                repo.save(new Course("Computer Applications", "BCA"));
                repo.save(new Course("Computer Applications", "MCA"));
            }
        };
    }
}