package com.nisanth.emsbackend.controller;

import com.nisanth.emsbackend.dto.EmployeeDto;
import com.nisanth.emsbackend.entity.Employee;
import com.nisanth.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmploye=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
    }

    // Build Get Empoloyee By id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id)
    {
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }


    // Build Get All  Empoloyees By id REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getALlEmployees()
    {
       List<EmployeeDto> employees= employeeService.getAllEmployees();
       return ResponseEntity.ok(employees);
    }
}
