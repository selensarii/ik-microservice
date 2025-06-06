package com.example.employee.dtos.requests;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CreateEmployeeRequestDTO {

    private String fullName;
    private String position;
    private String identityNumber;
    private String salary;
    private UUID projectId;


}