package com.lgi.employees.service;

import com.lgi.employees.dto.EmployeeDTO;
import com.lgi.employees.exception.EmployeeNotFoundException;
import com.lgi.employees.model.Employee;
import com.lgi.employees.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains Employee service implementation details.
 *
 * @author Kalpana Pochareddy
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder().email(employeeDTO.getEmail())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .department(employeeDTO.getDepartment())
                .build();
        Employee employeeEntity = employeesRepository.save(employee);
        return convertToDto(employeeEntity);
    }

    @Override
    public List<EmployeeDTO> fetchAllEmployees() {
        List<Employee> employees = (List<Employee>) employeesRepository.findAll();
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(String employeeId) {
        if (employeesRepository.existsById(employeeId)) {
            employeesRepository.deleteById(employeeId);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID " + employeeId);
        }
    }

    @Override
    public EmployeeDTO fetchEmployees(String employeeId) {
        return employeesRepository.findById(employeeId).map(this::convertToDto).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with ID " + employeeId)
        );
    }

    @Override
    public void deleteAllEmployees() {
        employeesRepository.deleteAll();
    }

    private EmployeeDTO convertToDto(Employee employeeEntity) {
        return EmployeeDTO.builder().email(employeeEntity.getEmail())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .department(employeeEntity.getDepartment())
                .build();
    }
}
