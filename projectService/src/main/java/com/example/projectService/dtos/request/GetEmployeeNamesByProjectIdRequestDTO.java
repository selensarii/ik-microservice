package com.example.projectService.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetEmployeeNamesByProjectIdRequestDTO {

    private String fullName;
}
