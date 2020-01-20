package com.ex.pma.dao;

import com.ex.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

// CRUD repository to access data in the database
// in the ProjectRepository we will reference this Interface
public interface ProjectRepository extends CrudRepository<Project, Long> {

}