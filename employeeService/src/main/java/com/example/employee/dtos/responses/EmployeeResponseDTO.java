package com.example.employee.dtos.responses;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private UUID id;
    private String fullName;
    private String position;
    private String identityNumber;
    private String salary;
    private UUID projectId;

}
