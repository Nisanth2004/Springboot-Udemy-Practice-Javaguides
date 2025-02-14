package com.nisanth.emsbackend.controller;

import com.nisanth.emsbackend.dto.EmployeeDto;
import com.nisanth.emsbackend.entity.Employee;
import com.nisanth.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://nisanth-ems.netlify.app/")
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

    // Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto upadtedEmployeeDto)
    {
       EmployeeDto employeeDto= employeeService.updateEmployee(id,upadtedEmployeeDto);
       return ResponseEntity.ok(employeeDto);
    }

    // Build the delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Succesfully");
    }
}
