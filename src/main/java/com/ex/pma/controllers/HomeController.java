package com.ex.pma.controllers;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.dao.ProjectRepository;
import com.ex.pma.entities.Employee;
import com.ex.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeesRepository empRepo;

    @GetMapping("")
    public String displayHome (Model model) {

        // Querying the database for Projects
        List<Project> projects = proRepo.findAll(); // return all the projects in the db
        List<Employee> employees = empRepo.findAll();

        // Querying the database for Employees
        model.addAttribute("projectsList", projects);
        model.addAttribute("EmployeesList", employees);

        return "main/home";
    }
}
