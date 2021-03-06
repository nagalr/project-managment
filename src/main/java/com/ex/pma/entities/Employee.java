package com.ex.pma.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EmployeeId;

    private String firstName;
    private String lastName;
    private String email;

    /*
     Cascade definition for the childes side, the Employees
     Most of the option included without 'Delete',
     we do not want to delete Employee after a Project delete
     PERSIST - will save to the db all the associated childes (employees), after a parent was saved to the db
     Merge - if project a merges with project b, the associated childes will be merged too
     Refresh - if the project refresh, the associated childes will refresh
    */
    @ManyToMany( cascade =
                { CascadeType.DETACH,
                  CascadeType.MERGE,
                  CascadeType.REFRESH,
                  CascadeType.PERSIST },
                fetch = FetchType.LAZY ) // Load a project to the memory, but not all the associated childes
    @JoinTable(name = "project_employee",
               joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "project_id")
               ) // Annotation to create a join table
    private List<Project> projects;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
