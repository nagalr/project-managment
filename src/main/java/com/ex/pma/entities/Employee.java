package com.ex.pma.entities;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long EmployeeId;

    private String firstName;
    private String lastName;
    private String email;

    // Most of the option without 'Delete',
    // we do not want to delete Employee after a Project delete
    // PERSIST - will save to the db a child, after a parent was saved
    @ManyToOne( cascade =
                { CascadeType.DETACH,
                  CascadeType.MERGE,
                  CascadeType.REFRESH,
                  CascadeType.PERSIST },
                fetch = FetchType.LAZY ) // Load a project to the memory, but not all the associated childes
    @JoinColumn(name = "project_id") // The 'Many' side of the relationship assign the Join Column
    private Project Project;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public com.ex.pma.entities.Project getProject() {
        return Project;
    }

    public void setProject(com.ex.pma.entities.Project project) {
        Project = project;
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
