package com.lgi.employees.controller;

import com.lgi.employees.dto.EmployeeDTO;
import com.lgi.employees.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller used to retrieve and delete employees details
 *
 * @author Kalpana Pochareddy
 */
@RestController
@RequestMapping("employees")
public class EmployeesController {
    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    @DeleteMapping("/all")
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }
}
