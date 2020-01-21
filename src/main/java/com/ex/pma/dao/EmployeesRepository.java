package com.ex.pma.dao;

import com.ex.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();
}
