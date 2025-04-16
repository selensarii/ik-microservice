package com.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponseDTO {
    private UUID id;
    private String fullName;
    private String position;
    private String identityNumber;
    private String salary;
    private UUID projectId;
}
