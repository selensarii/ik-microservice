package com.example.projectService.core.mapper;

import com.example.common.dto.AddProjectResponseDTO;
import com.example.projectService.dtos.request.CreateProjectRequestDTO;
import com.example.projectService.dtos.response.CreateProjectResponseDTO;
import com.example.projectService.dtos.response.ProjectResponseDto;
import com.example.projectService.dtos.response.UpdateProjectResponseDTO;
import com.example.projectService.entities.Project;

public interface MapperService {

    AddProjectResponseDTO toResponse(Project project);
    Project toEntitys(CreateProjectRequestDTO createProjectRequestDTO);
    CreateProjectResponseDTO toRespons(Project project);
    UpdateProjectResponseDTO toUpdateProjectResponse(Project project);
    ProjectResponseDto toResponseDto(Project project);
}
