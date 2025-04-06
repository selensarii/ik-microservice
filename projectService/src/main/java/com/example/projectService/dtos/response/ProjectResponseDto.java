package com.example.projectService.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProjectResponseDto {

    private UUID id;
    private String name;
    private Long maxEmployee;
    private Long minEmployee;
    private Long totalEmployee;
}
