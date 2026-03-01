package com.college;

import com.college.model.Course;
import com.college.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

       	@PostMapping("/chat")
    	@ResponseBody
    	public String chat(@RequestParam String message) {
        message = message.toLowerCase();

        // ================= DATABASE COURSE FETCH =================

        if (message.contains("computer")) {
            return getCoursesByDepartment("Computer Science");
        }

        else if (message.contains("mechanical")) {
            return getCoursesByDepartment("Mechanical");
        }

        else if (message.contains("civil")) {
            return getCoursesByDepartment("Civil");
        }

        else if (message.contains("management") || message.contains("mba")) {
            return getCoursesByDepartment("Management");
        }

        else if (message.contains("commerce") || message.contains("bcom")) {
            return getCoursesByDepartment("Commerce");
        }

        // ================= ELIGIBILITY =================

        else if (message.contains("eligibility")) {
            return "Eligibility Criteria:<br><br>" +
                    "Engineering: 10+2 with PCM (Minimum 60%).<br>" +
                    "Science: 10+2 with relevant subjects (Minimum 55%).<br>" +
                    "Commerce: 10+2 in Commerce or equivalent.<br>" +
                    "MBA: Any UG degree with minimum 60%.<br>" +
                    "Entrance exams may be required.";
        }

        // ================= FEES =================

        else if (message.contains("fees")) {
            return "Fee Structure:<br><br>" +
                    "Engineering: ₹50,000 per year<br>" +
                    "Science: ₹35,000 per year<br>" +
                    "Commerce: ₹30,000 per year<br>" +
                    "MBA: ₹75,000 per year";
        }

        // ================= PLACEMENTS =================

        else if (message.contains("placement")) {
            return "Placement Details:<br><br>" +
                    "• 95% Placement Rate<br>" +
                    "• Highest Package: ₹18 LPA<br>" +
                    "• Average Package: ₹5.5 LPA<br>" +
                    "• Top Recruiters: TCS, Infosys, Wipro, Amazon, HCL";
        }

        // ================= SCHOLARSHIP =================

        else if (message.contains("scholarship")) {
            return "Scholarship Programs:<br><br>" +
                    "• Merit-Based Scholarships<br>" +
                    "• Sports Quota Scholarships<br>" +
                    "• Government Scholarships<br>" +
                    "• Financial Assistance for EWS students";
        }

        // ================= CAMPUS =================

        else if (message.contains("campus") || message.contains("facilities")) {
            return "Campus Facilities:<br><br>" +
                    "• Smart Classrooms<br>" +
                    "• Central Library<br>" +
                    "• Advanced Laboratories<br>" +
                    "• Sports Complex<br>" +
                    "• Auditorium<br>" +
                    "• WiFi Enabled Campus<br>" +
                    "• Cafeteria & Food Court";
        }

        // ================= HOSTEL =================

        else if (message.contains("hostel")) {
            return "Hostel Facilities:<br><br>" +
                    "• Separate Hostel for Boys & Girls<br>" +
                    "• AC & Non-AC Rooms<br>" +
                    "• 24/7 Security<br>" +
                    "• Hygienic Mess<br>" +
                    "• WiFi Access";
        }

        // ================= ADMISSION PROCESS =================

        else if (message.contains("admission process")) {
            return "Admission Process:<br><br>" +
                    "1. Online Application Submission<br>" +
                    "2. Document Verification<br>" +
                    "3. Entrance Exam (if applicable)<br>" +
                    "4. Counseling / Interview<br>" +
                    "5. Fee Payment & Enrollment";
        }

        // ================= DEFAULT =================

        else {
            return "Sorry, I didn't understand.<br><br>" +
                    "You can ask about:<br>" +
                    "• Computer Science<br>" +
                    "• Mechanical<br>" +
                    "• Civil<br>" +
                    "• Management<br>" +
                    "• Commerce<br>" +
                    "• Eligibility<br>" +
                    "• Fees<br>" +
                    "• Placement<br>" +
                    "• Scholarship<br>" +
                    "• Campus<br>" +
                    "• Hostel<br>" +
                    "• Admission Process";
        }
    }

    // ================= HELPER METHOD =================

    private String getCoursesByDepartment(String department) {

        List<Course> courses = courseRepository.findByDepartmentIgnoreCase(department);

        if (courses.isEmpty()) {
            return "No courses found for " + department;
        }

        StringBuilder response = new StringBuilder(department + " Courses:<br><br>");

        for (Course c : courses) {
            response.append("• ")
                    .append(c.getCourseName())
                    .append(" (")
                    .append(c.getDuration())
                    .append(") - ")
                    .append(c.getFees())
                    .append("<br>");
        }

        return response.toString();
    }
}