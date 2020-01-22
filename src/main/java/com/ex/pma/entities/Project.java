package com.ex.pma.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Defines that this is an entity, an Object from this class will convert to a record in a database
// Each row in the database will have all the private fields of the Object
// The Java JPA persistence api with hibernate will manage that
@Entity
public class Project {

    @Id // Mention what is the generated value
    @GeneratedValue(strategy = GenerationType.AUTO) // Generate projectId value in the database
    private long projectId;

    private String name;
    private String stage; // NOTSTARTED COMPLETED INPROGRESS
    private String description;

    @ManyToMany( cascade =
                { CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.REFRESH,
                        CascadeType.PERSIST },
                fetch = FetchType.LAZY ) // Load a project to the memory, but not all the associated childes
    @JoinTable(name = "project_employee",
               joinColumns = @JoinColumn(name = "project_id"),
               inverseJoinColumns = @JoinColumn(name = "employee_id")
              ) // Annotation to create a join table
    private List<Employee> employees;

    public Project(){

    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // convenience method
    public void addEmployee (Employee emp) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(emp);
    }
}
