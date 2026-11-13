package com.example.ems.controller;
import com.example.ems.entity.Designation; import com.example.ems.repository.DesignationRepository;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/designations")
public class DesignationController {
 private final DesignationRepository repo; public DesignationController(DesignationRepository r){repo=r;}
 @GetMapping public String list(Model m){m.addAttribute("designations",repo.findAll());return "designations";}
 @PostMapping("/save") public String save(@ModelAttribute Designation d){repo.save(d);return "redirect:/designations";}
 @GetMapping("/delete/{id}") public String delete(@PathVariable Long id){repo.deleteById(id);return "redirect:/designations";}
}
