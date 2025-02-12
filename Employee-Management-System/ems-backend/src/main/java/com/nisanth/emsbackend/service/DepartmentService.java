package com.nisanth.emsbackend.service;

import com.nisanth.emsbackend.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long id);

    List<DepartmentDto> getALlDepartments();

    DepartmentDto updateDepartment(Long id,DepartmentDto updatedDepartment);

    void deleteDepartment(Long id);
}
