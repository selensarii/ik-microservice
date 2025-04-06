package com.example.projectService.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProjectRequestDTO {

    private String name;
    private Long maxEmployee;
    private Long minEmployee;
    private Long totalEmployee;
}
