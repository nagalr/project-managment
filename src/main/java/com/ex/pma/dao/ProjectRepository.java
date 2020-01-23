package com.ex.pma.dao;

import com.ex.pma.dto.ChartData;
import com.ex.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CRUD repository to access data in the database
// in the ProjectRepository we will reference this Interface
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value =
           "SELECT stage as label, COUNT(*) as value " +
           "FROM project " +
           "GROUP BY stage")
    public List<ChartData> getProjectStatus();
}
