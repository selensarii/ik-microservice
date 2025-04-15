package com.example.employee.business.concretes;

import com.example.common.dto.AddProjectResponseDTO;
import com.example.employee.business.abstracts.EmployeeService;
import com.example.employee.core.mapper.MapperService;
import com.example.employee.core.utils.MessageConstant;
import com.example.employee.dataAccess.EmployeeRepository;
import com.example.employee.dtos.requests.CreateEmployeeRequestDTO;
import com.example.employee.dtos.requests.ProjectDTO;
import com.example.employee.dtos.requests.UpdateEmployeeRequestDTO;
import com.example.employee.dtos.responses.CreateEmployeeResponseDTO;
import com.example.employee.dtos.responses.EmployeeResponseDTO;
import com.example.employee.dtos.responses.UpdateEmployeeResponseDTO;
import com.example.employee.entities.Employee;
import com.example.employee.library.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final MapperService mapperService;

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(mapperService::toResponsee)
                .collect(Collectors.toList());
    }

    @Override
    public CreateEmployeeResponseDTO addEmployee(CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        String url = "http://localhost:9005/projects/v1/projectId/{projectId}";
        ResponseEntity<AddProjectResponseDTO> responseEntity = restTemplate.getForEntity(
                url, AddProjectResponseDTO.class, createEmployeeRequestDTO.getProjectId());

        AddProjectResponseDTO addProjectResponseDTO = responseEntity.getBody();

        if (addProjectResponseDTO != null) {
            createEmployeeRequestDTO.setProjectId(addProjectResponseDTO.getId());
        }

        Employee employee = mapperService.toEntity(createEmployeeRequestDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return mapperService.toCreateEmployeeResponse(savedEmployee);
    }
    
    @Override
    public EmployeeResponseDTO getById(String id) {
        UUID employeeId = UUID.fromString(id);
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageConstant.EMPLOYEE_NOT_FOUND));
        return mapperService.toResponsee(employee);
    }

    @Override
    public UpdateEmployeeResponseDTO updateEmployee(UpdateEmployeeRequestDTO updateEmployeeRequestDTO) {
        UUID employeeId = updateEmployeeRequestDTO.getId();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageConstant.EMPLOYEE_NOT_FOUND));
        return mapperService.toUpdateEmployeeResponse(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        UUID employeeId = UUID.fromString(id);
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public String getFindEmployeeFullNameById(String id) {
        return employeeRepository.findEmployeeFullNameById(UUID.fromString(id));
    }
}
