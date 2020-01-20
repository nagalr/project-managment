package com.ex.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @RequestMapping("/new")
    public String displayProjectForm(Model model) {

        model.addAttribute("project", aProject);
        return "new-project";
    }
}
