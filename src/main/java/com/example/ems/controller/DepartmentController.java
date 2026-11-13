package com.example.ems.controller;
import com.example.ems.entity.Department; import com.example.ems.repository.DepartmentRepository;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/departments")
public class DepartmentController {
 private final DepartmentRepository repo; public DepartmentController(DepartmentRepository r){repo=r;}
 @GetMapping public String list(Model m){m.addAttribute("departments",repo.findAll());return "departments";}
 @PostMapping("/save") public String save(@ModelAttribute Department d){repo.save(d);return "redirect:/departments";}
 @GetMapping("/delete/{id}") public String delete(@PathVariable Long id){repo.deleteById(id);return "redirect:/departments";}
}
