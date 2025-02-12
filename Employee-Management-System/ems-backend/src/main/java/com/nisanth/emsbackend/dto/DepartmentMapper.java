package com.nisanth.emsbackend.dto;

import com.nisanth.emsbackend.entity.Department;

public class DepartmentMapper {

    // convert department jpa entity into department dto
    public static  DepartmentDto mapToDepartmentDto(Department department)
    {
        return new DepartmentDto(
                department.getId(),
                department.getDepartMentName(),
                department.getDepartmentDescription()
        );
    }

    // convert department dto into department jpa entity

    public static Department mapToDepartment(DepartmentDto departmentDto)
    {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartMentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
