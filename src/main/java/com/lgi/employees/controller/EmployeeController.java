package com.lgi.employees.controller;

import com.lgi.employees.dto.EmployeeDTO;
import com.lgi.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This controller used to retrieve, add and delete employee details
 *
 * @author Kalpana Pochareddy
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable String id) {
        return employeeService.fetchEmployees(id);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO dto = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
