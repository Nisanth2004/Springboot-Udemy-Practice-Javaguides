package com.nisanth.emsbackend.service.impl;

import com.nisanth.emsbackend.dto.EmployeeDto;
import com.nisanth.emsbackend.dto.EmployeeMapper;
import com.nisanth.emsbackend.entity.Employee;
import com.nisanth.emsbackend.exception.ResourceNotFoundException;
import com.nisanth.emsbackend.repository.EmployeeRepository;
import com.nisanth.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //  convert the EmployeeDto to Employee entity to store in database

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);

        // return the employeeDto instead of entity to aviod to transfer sensitive

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

      Employee employee=  employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee does not exist by this id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

       List<Employee> employees= employeeRepository.findAll();

       // employee entity is convert to list of employee DTO's

        return employees.stream().map((employee )->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }
}
