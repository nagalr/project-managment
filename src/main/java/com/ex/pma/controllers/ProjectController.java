package com.ex.pma.controllers;

import com.ex.pma.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project(); // Bind an empty Object to the form
        model.addAttribute("project", aProject); // in the html form the Object name is "project"
        return "new-project";
    }

    @PostMapping("/save")
    public String saveProjectForm(Project project, Model model) {
        // This method should handle saving to the database
        return "";
    }
}
