package com.ex.pma.controllers;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.dao.ProjectRepository;
import com.ex.pma.dto.ChartData;
import com.ex.pma.dto.EmployeeProject;
import com.ex.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeesRepository empRepo;

    @GetMapping("")
    public String displayHome (Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        // Querying the database for Projects and Employees
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectList", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        // Convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("ProjectStatusCnt", jsonString);

        List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
        model.addAttribute("EmployeesListProjectsCnt", employeesProjectCnt);

        return "main/home";
    }
}
