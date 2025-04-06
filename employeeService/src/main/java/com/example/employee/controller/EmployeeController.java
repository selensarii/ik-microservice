package com.example.employee.controller;

import com.example.employee.business.abstracts.EmployeeService;
import com.example.employee.core.utils.MessageConstant;
import com.example.employee.dtos.requests.CreateEmployeeRequestDTO;
import com.example.employee.dtos.requests.UpdateEmployeeRequestDTO;
import com.example.employee.dtos.responses.CreateEmployeeResponseDTO;
import com.example.employee.dtos.responses.EmployeeResponseDTO;
import com.example.employee.dtos.responses.UpdateEmployeeResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeService.getAllEmployees();
    }


    @PostMapping
    public CreateEmployeeResponseDTO addEmployee(@RequestBody CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        return employeeService.addEmployee(createEmployeeRequestDTO);
    }

    @PutMapping("/v1/employeeId")
    public UpdateEmployeeResponseDTO updateEmployee(@RequestBody UpdateEmployeeRequestDTO updateEmployeeRequestDTO) throws JsonProcessingException {
        return employeeService.updateEmployee(updateEmployeeRequestDTO);
    }

    @DeleteMapping("/v1/employeeId/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(MessageConstant.EMPLOYEE_DELETED_SUCCESSFULLY + employeeId);
    }

    @GetMapping("/v1/fullName/employeeId/{employeeId}")
    public String getEmployeeFullName(@PathVariable String employeeId) {
        return employeeService.getFindEmployeeFullNameById(employeeId);
    }
}
