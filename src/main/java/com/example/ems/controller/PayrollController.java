package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.entity.Payroll;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.repository.PayrollRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollRepository repo;
    private final EmployeeRepository employees;

    public PayrollController(PayrollRepository repo, EmployeeRepository employees) {
        this.repo = repo;
        this.employees = employees;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("payrolls", repo.findAll());
        model.addAttribute("employees", employees.findAll());
        return "payroll";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Payroll payroll, RedirectAttributes redirectAttributes) {
        if (payroll.getEmployee() == null || payroll.getEmployee().getId() == null) {
            redirectAttributes.addFlashAttribute("error", "Please select an employee.");
            return "redirect:/payroll";
        }

        Employee employee = employees.findById(payroll.getEmployee().getId()).orElse(null);
        if (employee == null) {
            redirectAttributes.addFlashAttribute("error", "Selected employee was not found.");
            return "redirect:/payroll";
        }

        if (payroll.getMonth() == null || payroll.getMonth().isBlank()) {
            redirectAttributes.addFlashAttribute("error", "Please enter the payroll month.");
            return "redirect:/payroll";
        }

        BigDecimal basic = employee.getSalary() == null ? BigDecimal.ZERO : employee.getSalary();
        BigDecimal allowances = payroll.getAllowances() == null ? BigDecimal.ZERO : payroll.getAllowances();
        BigDecimal deductions = payroll.getDeductions() == null ? BigDecimal.ZERO : payroll.getDeductions();

        if (allowances.compareTo(BigDecimal.ZERO) < 0 || deductions.compareTo(BigDecimal.ZERO) < 0) {
            redirectAttributes.addFlashAttribute("error", "Allowances and deductions cannot be negative.");
            return "redirect:/payroll";
        }

        BigDecimal gross = basic.add(allowances);
        BigDecimal net = gross.subtract(deductions);
        if (net.compareTo(BigDecimal.ZERO) < 0) {
            redirectAttributes.addFlashAttribute("error", "Deductions cannot be greater than the gross salary.");
            return "redirect:/payroll";
        }

        // Keep the payroll record connected to the real employee and calculate
        // the basic/net salary from the employee's current salary.
        payroll.setEmployee(employee);
        payroll.setBasicSalary(basic);
        payroll.setAllowances(allowances);
        payroll.setDeductions(deductions);
        payroll.setNetSalary(net);

        repo.save(payroll);
        redirectAttributes.addFlashAttribute("success", "Payroll saved successfully for " + employee.getName() + ".");
        return "redirect:/payroll";
    }
}
