package com.ex.pma;

import com.ex.pma.dao.EmployeesRepository;
import com.ex.pma.dao.ProjectRepository;
import com.ex.pma.entities.Employee;
import com.ex.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectManagmentApplication {

    @Autowired
    EmployeesRepository empRepo;

    @Autowired
    ProjectRepository projRepo;

    public static void main(String[] args) {

        SpringApplication.run(ProjectManagmentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
            Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
            Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");

            Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
            Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
            Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");

            Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
            Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
            Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");

            Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
                    + "the final deployment of the software into production");
            Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
                    + "for the year and figureout who will be promoted");
            Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
                    + "been damaged due to hurricane in the region. This needs to be reconstructed");
            Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
                    + "security needs to be improved and proper security team needs to be hired for "
                    + "implementation");

        };
    }
}
