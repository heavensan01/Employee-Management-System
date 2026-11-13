package com.example.ems.controller;

import com.example.ems.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
 private final EmployeeRepository employees; private final DepartmentRepository departments;
 private final AttendanceRepository attendance; private final PayrollRepository payroll;
 public DashboardController(EmployeeRepository e,DepartmentRepository d,AttendanceRepository a,PayrollRepository p){
  employees=e;departments=d;attendance=a;payroll=p;
 }
 @GetMapping("/") public String dashboard(Model m){
  m.addAttribute("employeeCount",employees.count()); m.addAttribute("departmentCount",departments.count());
  m.addAttribute("attendanceCount",attendance.count()); m.addAttribute("payrollCount",payroll.count());
  return "dashboard";
 }
}
