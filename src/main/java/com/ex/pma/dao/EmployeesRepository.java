package com.ex.pma.dao;

import com.ex.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employee, Long> {

}
