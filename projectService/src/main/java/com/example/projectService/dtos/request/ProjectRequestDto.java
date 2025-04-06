package com.example.projectService.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProjectRequestDto {

    private UUID id;
    private String name;
    private Long maxEmployee;
    private Long minEmployee;
    private Long totalEmployee;
}
