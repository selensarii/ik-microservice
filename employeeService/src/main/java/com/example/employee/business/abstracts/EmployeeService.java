package com.example.employee.business.abstracts;

import com.example.employee.dtos.requests.CreateEmployeeRequestDTO;
import com.example.employee.dtos.requests.UpdateEmployeeRequestDTO;
import com.example.employee.dtos.responses.CreateEmployeeResponseDTO;
import com.example.employee.dtos.responses.EmployeeResponseDTO;
import com.example.employee.dtos.responses.UpdateEmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO getById(String id);
    void deleteEmployee(String id);
    String getFindEmployeeFullNameById(String id);

    CreateEmployeeResponseDTO addEmployee(CreateEmployeeRequestDTO createEmployeeRequestDTO);
    UpdateEmployeeResponseDTO updateEmployee(UpdateEmployeeRequestDTO updateEmployeeRequestDTO);

}
