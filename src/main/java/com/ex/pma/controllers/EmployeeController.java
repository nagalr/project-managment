package com.ex.pma.controllers;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeesRepository empRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee aEmployee = new Employee();
        model.addAttribute("employee", aEmployee);

        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployeeForm(Employee employee, Model model) {

        empRepo.save(employee);

        return "redirect:/employees/new";
    }
}
