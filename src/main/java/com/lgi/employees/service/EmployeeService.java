package com.lgi.employees.service;

import com.lgi.employees.dto.EmployeeDTO;

import java.util.List;

/**
 * This class contains Employee service details.
 *
 * @author Kalpana Pochareddy
 */
public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> fetchAllEmployees();
    void deleteEmployee(String employeeId);
    EmployeeDTO fetchEmployees(String employeeId);

    void deleteAllEmployees();
}
