package com.nisanth.emsbackend.service.impl;

import com.nisanth.emsbackend.dto.DepartmentDto;
import com.nisanth.emsbackend.dto.DepartmentMapper;
import com.nisanth.emsbackend.entity.Department;
import com.nisanth.emsbackend.exception.ResourceNotFoundException;
import com.nisanth.emsbackend.repository.DepartmentRepository;
import com.nisanth.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        // convert incoming request into entity to store in database
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);


        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {

       Department department= departmentRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Department is not exists by this is: "+id));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getALlDepartments() {
        List<Department> departments=departmentRepository.findAll();
        return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto updatedDepartment) {


        Department department= departmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department is not exists by this is: "+id));
        department.setDepartMentName(updatedDepartment.getDepartMentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
       Department savedDepartent= departmentRepository.save(department);


        return DepartmentMapper.mapToDepartmentDto(savedDepartent);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department= departmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department is not exists by this is: "+id));

        departmentRepository.deleteById(id);
    }
}
