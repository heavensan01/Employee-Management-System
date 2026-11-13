package com.example.ems.config;

import com.example.ems.entity.Department;
import com.example.ems.entity.Designation;
import com.example.ems.entity.Employee;
import com.example.ems.entity.Role;
import com.example.ems.entity.User;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.repository.DesignationRepository;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(
            UserRepository users,
            DepartmentRepository departments,
            DesignationRepository designations,
            EmployeeRepository employees,
            PasswordEncoder encoder) {

        return args -> {
            if (users.findByEmail("admin@example.com").isEmpty()) {
                users.save(new User(
                        "Administrator",
                        "admin@example.com",
                        encoder.encode("admin123"),
                        Role.ADMIN));
            }

            if (users.findByEmail("employee@example.com").isEmpty()) {
                users.save(new User(
                        "Demo Employee",
                        "employee@example.com",
                        encoder.encode("employee123"),
                        Role.EMPLOYEE));
            }

            Department it = departments.findAll().stream()
                    .filter(d -> "Information Technology".equalsIgnoreCase(d.getName()))
                    .findFirst()
                    .orElseGet(() -> departments.save(new Department("Information Technology")));

            Department hr = departments.findAll().stream()
                    .filter(d -> "Human Resources".equalsIgnoreCase(d.getName()))
                    .findFirst()
                    .orElseGet(() -> departments.save(new Department("Human Resources")));

            Designation developer = designations.findAll().stream()
                    .filter(d -> "Software Developer".equalsIgnoreCase(d.getName()))
                    .findFirst()
                    .orElseGet(() -> designations.save(new Designation("Software Developer")));

            Designation manager = designations.findAll().stream()
                    .filter(d -> "HR Manager".equalsIgnoreCase(d.getName()))
                    .findFirst()
                    .orElseGet(() -> designations.save(new Designation("HR Manager")));

            // Add 50 realistic demo employees only when their email is not already present.
            Object[][] employeeData = {
                {"Arun Kumar", "arun.kumar@company.com", "9876501001", "Chennai", "55000", "Information Technology", "Software Developer"},
                {"Priya Sharma", "priya.sharma@company.com", "9876501002", "Bengaluru", "58000", "Human Resources", "HR Executive"},
                {"Rahul Verma", "rahul.verma@company.com", "9876501003", "Mumbai", "72000", "Finance", "Finance Manager"},
                {"Sneha Iyer", "sneha.iyer@company.com", "9876501004", "Chennai", "62000", "Information Technology", "Senior Software Developer"},
                {"Karthik Raj", "karthik.raj@company.com", "9876501005", "Coimbatore", "48000", "Sales", "Sales Executive"},
                {"Divya Nair", "divya.nair@company.com", "9876501006", "Kochi", "51000", "Marketing", "Marketing Executive"},
                {"Vikram Singh", "vikram.singh@company.com", "9876501007", "Delhi", "85000", "Information Technology", "Project Manager"},
                {"Ananya Reddy", "ananya.reddy@company.com", "9876501008", "Hyderabad", "65000", "Information Technology", "UI/UX Designer"},
                {"Suresh Babu", "suresh.babu@company.com", "9876501009", "Chennai", "47000", "Operations", "Operations Executive"},
                {"Meera Krishnan", "meera.krishnan@company.com", "9876501010", "Madurai", "60000", "Human Resources", "HR Manager"},
                {"Rohit Mehta", "rohit.mehta@company.com", "9876501011", "Pune", "76000", "Information Technology", "Backend Developer"},
                {"Lakshmi Devi", "lakshmi.devi@company.com", "9876501012", "Chennai", "52000", "Finance", "Accountant"},
                {"Naveen Kumar", "naveen.kumar@company.com", "9876501013", "Bengaluru", "69000", "Information Technology", "Frontend Developer"},
                {"Pooja Patel", "pooja.patel@company.com", "9876501014", "Ahmedabad", "57000", "Marketing", "Marketing Manager"},
                {"Ajay Menon", "ajay.menon@company.com", "9876501015", "Kochi", "49000", "Sales", "Sales Executive"},
                {"Harini Rao", "harini.rao@company.com", "9876501016", "Hyderabad", "54000", "Information Technology", "QA Engineer"},
                {"Manoj Kumar", "manoj.kumar@company.com", "9876501017", "Chennai", "61000", "Operations", "Operations Manager"},
                {"Aishwarya Das", "aishwarya.das@company.com", "9876501018", "Kolkata", "53000", "Human Resources", "Recruiter"},
                {"Sanjay Menon", "sanjay.menon@company.com", "9876501019", "Chennai", "68000", "Information Technology", "DevOps Engineer"},
                {"Neha Gupta", "neha.gupta@company.com", "9876501020", "Delhi", "59000", "Finance", "Financial Analyst"},
                {"Deepak Joshi", "deepak.joshi@company.com", "9876501021", "Jaipur", "63000", "Information Technology", "Database Administrator"},
                {"Kavya Srinivasan", "kavya.srinivasan@company.com", "9876501022", "Chennai", "50000", "Marketing", "Content Specialist"},
                {"Vishal Kapoor", "vishal.kapoor@company.com", "9876501023", "Mumbai", "71000", "Sales", "Sales Manager"},
                {"Swathi R", "swathi.r@company.com", "9876501024", "Bengaluru", "56000", "Information Technology", "Business Analyst"},
                {"Gokul Krishnan", "gokul.krishnan@company.com", "9876501025", "Coimbatore", "45000", "Operations", "Operations Executive"},
                {"Riya Shah", "riya.shah@company.com", "9876501026", "Ahmedabad", "64000", "Human Resources", "Training Manager"},
                {"Prakash Rao", "prakash.rao@company.com", "9876501027", "Hyderabad", "78000", "Information Technology", "Technical Lead"},
                {"Nithya Joseph", "nithya.joseph@company.com", "9876501028", "Kochi", "51000", "Finance", "Accounts Executive"},
                {"Akash Malhotra", "akash.malhotra@company.com", "9876501029", "Delhi", "67000", "Information Technology", "Mobile App Developer"},
                {"Keerthana S", "keerthana.s@company.com", "9876501030", "Chennai", "55000", "Marketing", "Digital Marketing Executive"},
                {"Mohan Das", "mohan.das@company.com", "9876501031", "Kolkata", "73000", "Operations", "Operations Manager"},
                {"Ishita Roy", "ishita.roy@company.com", "9876501032", "Kolkata", "52000", "Human Resources", "HR Executive"},
                {"Varun Reddy", "varun.reddy@company.com", "9876501033", "Hyderabad", "66000", "Information Technology", "Software Developer"},
                {"Janani Balaji", "janani.balaji@company.com", "9876501034", "Chennai", "49000", "Finance", "Accountant"},
                {"Abhishek Jain", "abhishek.jain@company.com", "9876501035", "Pune", "80000", "Information Technology", "Senior Software Developer"},
                {"Reshma Thomas", "reshma.thomas@company.com", "9876501036", "Kochi", "58000", "Sales", "Sales Executive"},
                {"Tarun Gupta", "tarun.gupta@company.com", "9876501037", "Delhi", "62000", "Marketing", "Marketing Executive"},
                {"Bhavana Murthy", "bhavana.murthy@company.com", "9876501038", "Bengaluru", "70000", "Information Technology", "QA Lead"},
                {"Ramesh Chandran", "ramesh.chandran@company.com", "9876501039", "Chennai", "74000", "Operations", "Operations Manager"},
                {"Shreya Kapoor", "shreya.kapoor@company.com", "9876501040", "Mumbai", "61000", "Human Resources", "Recruiter"},
                {"Dinesh Kumar", "dinesh.kumar@company.com", "9876501041", "Chennai", "57000", "Information Technology", "System Administrator"},
                {"Madhumitha P", "madhumitha.p@company.com", "9876501042", "Madurai", "53000", "Finance", "Financial Analyst"},
                {"Yashwanth Rao", "yashwanth.rao@company.com", "9876501043", "Hyderabad", "75000", "Information Technology", "Cloud Engineer"},
                {"Sowmya Lakshmi", "sowmya.lakshmi@company.com", "9876501044", "Bengaluru", "56000", "Marketing", "Content Specialist"},
                {"Nikhil Arora", "nikhil.arora@company.com", "9876501045", "Delhi", "68000", "Sales", "Business Development Executive"},
                {"Gayathri V", "gayathri.v@company.com", "9876501046", "Chennai", "59000", "Human Resources", "HR Executive"},
                {"Surya Prakash", "surya.prakash@company.com", "9876501047", "Coimbatore", "65000", "Information Technology", "Software Developer"},
                {"Monika Singh", "monika.singh@company.com", "9876501048", "Jaipur", "60000", "Operations", "Operations Executive"},
                {"Aditya Bose", "aditya.bose@company.com", "9876501049", "Kolkata", "77000", "Information Technology", "Project Manager"},
                {"Shalini Menon", "shalini.menon@company.com", "9876501050", "Kochi", "54000", "Finance", "Accounts Executive"}
            };

            for (Object[] data : employeeData) {
                String email = (String) data[1];
                if (employees.findByEmail(email).isEmpty()) {
                    Employee e = new Employee();
                    e.setName((String) data[0]);
                    e.setEmail(email);
                    e.setPhone((String) data[2]);
                    e.setAddress((String) data[3]);
                    e.setSalary(new BigDecimal((String) data[4]));
                    String deptName = (String) data[5];
                    String designationName = (String) data[6];
                    Department employeeDept = departments.findAll().stream()
                            .filter(d -> deptName.equalsIgnoreCase(d.getName()))
                            .findFirst().orElseGet(() -> departments.save(new Department(deptName)));
                    Designation employeeDesignation = designations.findAll().stream()
                            .filter(d -> designationName.equalsIgnoreCase(d.getName()))
                            .findFirst().orElseGet(() -> designations.save(new Designation(designationName)));
                    e.setDepartment(employeeDept);
                    e.setDesignation(employeeDesignation);
                    employees.save(e);
                }
            }
        };
    }
}
