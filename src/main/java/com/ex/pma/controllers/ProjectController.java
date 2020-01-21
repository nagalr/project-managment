package com.ex.pma.controllers;

import com.ex.pma.dao.ProjectRepository;
import com.ex.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired // Spring will create an Instance from this interface
    ProjectRepository proRepo; // we will use this to save our Project instance

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project(); // Bind an empty Object to the form
        model.addAttribute("project", aProject); // in the html form the Object name is "project"
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        // This method should handle saving to the database
        proRepo.save(project);

        return "redirect:/projects/new";  // Redirecting to prevent duplicate submissions (we can redirect to any page)
    }
}
