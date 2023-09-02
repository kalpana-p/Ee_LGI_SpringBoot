package com.lgi.employees.repository;

import com.lgi.employees.model.Employee;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * The employees repository details.
 *
 * @author Kalpana Pochareddy
 */
@EnableScan
public interface EmployeesRepository extends CrudRepository<Employee, String> {
}
