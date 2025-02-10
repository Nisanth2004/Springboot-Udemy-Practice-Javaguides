package com.nisanth.emsbackend.service.impl;

import com.nisanth.emsbackend.dto.EmployeeDto;
import com.nisanth.emsbackend.dto.EmployeeMapper;
import com.nisanth.emsbackend.entity.Employee;
import com.nisanth.emsbackend.repository.EmployeeRepository;
import com.nisanth.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
