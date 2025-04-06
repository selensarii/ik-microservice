package com.example.employee.core.mapper;

import com.example.employee.dtos.requests.CreateEmployeeRequestDTO;
import com.example.employee.dtos.responses.CreateEmployeeResponseDTO;
import com.example.employee.dtos.responses.EmployeeResponseDTO;
import com.example.employee.dtos.responses.UpdateEmployeeResponseDTO;
import com.example.employee.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class MapperServiceImpl implements MapperService {

    @Override
    public CreateEmployeeResponseDTO toCreateEmployeeResponse(Employee savedEmployee) {
        return new CreateEmployeeResponseDTO(
                savedEmployee.getId(),
                savedEmployee.getFullName(),
                savedEmployee.getPosition(),
                savedEmployee.getIdentityNumber(),
                savedEmployee.getSalary(),
                savedEmployee.getProjectId()
        );
    }

    @Override
    public Employee toEntity(CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        Employee employee = new Employee();
        employee.setFullName(createEmployeeRequestDTO.getFullName());
        employee.setPosition(createEmployeeRequestDTO.getPosition());
        employee.setIdentityNumber(createEmployeeRequestDTO.getIdentityNumber());
        employee.setSalary(createEmployeeRequestDTO.getSalary());
        employee.setProjectId(createEmployeeRequestDTO.getProjectId());
        return employee;
    }

    @Override
    public EmployeeResponseDTO toResponsee(Employee employee) {
        EmployeeResponseDTO employeeResponseDto = new EmployeeResponseDTO();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setProjectId(employee.getProjectId());
        employeeResponseDto.setFullName(employee.getFullName());
        employeeResponseDto.setPosition(employee.getPosition());
        employeeResponseDto.setIdentityNumber(employee.getIdentityNumber());
        employeeResponseDto.setSalary(employee.getSalary());
        return employeeResponseDto;
    }

    @Override
    public UpdateEmployeeResponseDTO toUpdateEmployeeResponse(Employee employee) {
        UpdateEmployeeResponseDTO updateEmployeeResponseDTO = new UpdateEmployeeResponseDTO();
        updateEmployeeResponseDTO.setFullName(employee.getFullName());
        updateEmployeeResponseDTO.setPosition(employee.getPosition());
        updateEmployeeResponseDTO.setIdentityNumber(employee.getIdentityNumber());
        updateEmployeeResponseDTO.setSalary(employee.getSalary());
        return updateEmployeeResponseDTO;
    }

}
