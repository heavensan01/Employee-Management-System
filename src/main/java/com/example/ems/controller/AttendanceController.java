package com.example.ems.controller;
import com.example.ems.entity.Attendance; import com.example.ems.repository.*;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import java.time.LocalDate;
@Controller @RequestMapping("/attendance")
public class AttendanceController {
 private final AttendanceRepository repo; private final EmployeeRepository employees;
 public AttendanceController(AttendanceRepository r,EmployeeRepository e){repo=r;employees=e;}
 @GetMapping public String list(Model m){m.addAttribute("attendance",repo.findAllByOrderByDateDesc());m.addAttribute("employees",employees.findAll());m.addAttribute("today", LocalDate.now());return "attendance";}
 @PostMapping("/save") public String save(@ModelAttribute Attendance a){if(a.getDate()==null)a.setDate(LocalDate.now());repo.save(a);return "redirect:/attendance";}
}
