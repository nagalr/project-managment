package com.ex.pma;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagmentApplication {

    @Autowired
    EmployeesRepository empRepo;

    @Autowired
    ProjectRepository projRepo;

    public static void main(String[] args) {

        SpringApplication.run(ProjectManagmentApplication.class, args);
    }

}
