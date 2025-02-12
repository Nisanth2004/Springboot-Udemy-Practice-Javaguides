package com.nisanth.emsbackend.controller;

import com.nisanth.emsbackend.dto.DepartmentDto;
import com.nisanth.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build Add department REST API

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
    {
       DepartmentDto department= departmentService.createDepartment(departmentDto);
       return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // Build get department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id)
    {
       DepartmentDto departmentDto= departmentService.getDepartmentById(id);
       return ResponseEntity.ok(departmentDto);
    }

    // Build get all departmenst REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments()
    {
       List<DepartmentDto> departmentDtos= departmentService.getALlDepartments();
       return ResponseEntity.ok(departmentDtos);
    }

    // Build Update department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto udatedDepartment)
    {
        DepartmentDto departmentDto=departmentService.updateDepartment(departmentId,udatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    // Build delete department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id)
    {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
