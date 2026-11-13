package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping("/employees")
public class EmployeeController {
 private final EmployeeRepository repo; private final DepartmentRepository dept; private final DesignationRepository desig;
 public EmployeeController(EmployeeRepository r,DepartmentRepository d,DesignationRepository g){repo=r;dept=d;desig=g;}
 @GetMapping public String list(Model m){m.addAttribute("employees",repo.findAll());return "employees";}
 @GetMapping("/new") public String form(Model m){m.addAttribute("employee",new Employee());m.addAttribute("departments",dept.findAll());m.addAttribute("designations",desig.findAll());return "employee-form";}
 @PostMapping("/save") public String save(@ModelAttribute Employee e){repo.save(e);return "redirect:/employees";}
 @GetMapping("/edit/{id}") public String edit(@PathVariable Long id,Model m){m.addAttribute("employee",repo.findById(id).orElseThrow());m.addAttribute("departments",dept.findAll());m.addAttribute("designations",desig.findAll());return "employee-form";}
 @GetMapping("/delete/{id}") public String delete(@PathVariable Long id){repo.deleteById(id);return "redirect:/employees";}
}
