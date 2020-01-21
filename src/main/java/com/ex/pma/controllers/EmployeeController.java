package com.ex.pma.controllers;

import com.ex.pma.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee aEmployee = new Employee();
        model.addAttribute("employee", aEmployee);

        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployeeForm() {

        return "redirect:/employees/new";
    }

}
