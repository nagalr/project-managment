package com.ex.pma.controllers;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.dao.ProjectRepository;
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
@RequestMapping("/projects")
public class ProjectController {

    @Autowired // Spring will create an Instance from this interface
    ProjectRepository proRepo; // we will use this to save our Project instance

    @Autowired
    EmployeesRepository empRepo;

    @RequestMapping("") // or @GetMapping
    public String showCurrentProjects(Model model) {

        // Querying the database for Projects and Employees
        List<Project> projects = proRepo.findAll(); // return all the projects in the db

        model.addAttribute("projectsList", projects);
        return "projects/CurrentProjects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project(); // Bind an empty Object to the form
        List<Employee> employees = empRepo.findAll();

        // in the html form the Object name is "project"
        model.addAttribute("project", aProject);

        /*
         Sending to 'new-project.html' the 'employees' from two lines above
         So 'employees' will be mapped to the 'allEmployees' variable
        */
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {

        // This method should handle saving to the database
        proRepo.save(project);

        return "redirect:/projects";  // Redirecting to prevent duplicate submissions (we can redirect to any page)
    }
}
