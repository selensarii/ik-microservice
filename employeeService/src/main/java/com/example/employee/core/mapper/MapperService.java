package com.example.employee.core.mapper;

import com.example.employee.dtos.requests.CreateEmployeeRequestDTO;
import com.example.employee.dtos.responses.CreateEmployeeResponseDTO;
import com.example.employee.dtos.responses.EmployeeResponseDTO;
import com.example.employee.dtos.responses.UpdateEmployeeResponseDTO;
import com.example.employee.entities.Employee;


public interface MapperService {

    CreateEmployeeResponseDTO toCreateEmployeeResponse(Employee savedEmployee);
    Employee toEntity(CreateEmployeeRequestDTO createEmployeeRequestDTO);
    EmployeeResponseDTO toResponsee(Employee employee);
    UpdateEmployeeResponseDTO toUpdateEmployeeResponse(Employee employee);
}
