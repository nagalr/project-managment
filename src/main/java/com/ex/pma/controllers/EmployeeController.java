package com.ex.pma.controllers;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.entities.Employee;
import com.ex.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeesRepository empRepo;

    @RequestMapping("")
    public String showCurrentEmployees(Model model) {
        // Querying the database for Projects and Employees
        List<Employee> employees = empRepo.findAll(); // return all the projects in the db

        model.addAttribute("EmployeesList", employees);
        return "employees/currentEmployees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee aEmployee = new Employee();
        model.addAttribute("employee", aEmployee);

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {

        // save to the database using an employee crud repository
        empRepo.save(employee);

        return "redirect:/employees/new";
    }
}
