package com.example.projectService.business.abstracts;

import com.example.projectService.dtos.request.CreateProjectRequestDTO;
import com.example.projectService.dtos.request.UpdateProjectRequestDTO;
import com.example.projectService.dtos.response.*;
import com.example.projectService.entities.Project;

import java.util.List;

public interface ProjectService {

    List<ProjectResponseDto> getAllProjects();
    Project findById(String id);
    ProjectResponseDto getById(String id);
    void deleteProject(String id);

    UpdateProjectResponseDTO updateProject(UpdateProjectRequestDTO updateProjectRequestDTO);
    CreateProjectResponseDTO addProject(CreateProjectRequestDTO createProjectRequestDTO);


}
