package com.example.projectService.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetFindEmployeesByProjectIdRequestDTO {

    private String fullName;
    private String position;
    private String identityNumber;
    private String salary;
}
