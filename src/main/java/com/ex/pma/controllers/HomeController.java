package com.ex.pma.controllers;

import com.ex.pma.dao.ProjectRepository;
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

    @GetMapping("/")
    public String displayHome (Model model) {
        List<Project> projects = proRepo.findAll(); // return all the projects in the db
        model.addAttribute("projectsList", projects);
        return "home";
    }
}
