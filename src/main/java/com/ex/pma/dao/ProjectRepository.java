package com.ex.pma.dao;

import com.ex.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> { // CRUD repository to access data in the database

}