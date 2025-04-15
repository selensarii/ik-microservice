package com.example.projectService.core.mapper;

import com.example.common.dto.AddProjectResponseDTO;
import com.example.projectService.dtos.request.CreateProjectRequestDTO;
import com.example.projectService.dtos.response.CreateProjectResponseDTO;
import com.example.projectService.dtos.response.ProjectResponseDto;
import com.example.projectService.dtos.response.UpdateProjectResponseDTO;
import com.example.projectService.entities.Project;
import org.springframework.stereotype.Service;

@Service
public class MapperServiceImpl implements MapperService {

    @Override
    public AddProjectResponseDTO toResponse(Project project) {
        return new AddProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getMaxEmployee(),
                project.getMinEmployee(),
                project.getTotalEmployee()
        );
    }
    @Override
    public ProjectResponseDto toResponseDto(Project project) {
        return new ProjectResponseDto(
                project.getId(),
                project.getName(),
                project.getMaxEmployee(),
                project.getMinEmployee(),
                project.getTotalEmployee()
        );
    }


    @Override
    public Project toEntitys(CreateProjectRequestDTO createProjectRequestDTO) {
        Project project = new Project();
        project.setName(createProjectRequestDTO.getName());
        project.setMinEmployee(createProjectRequestDTO.getMinEmployee());
        project.setMaxEmployee(createProjectRequestDTO.getMaxEmployee());
        project.setTotalEmployee(createProjectRequestDTO.getTotalEmployee());
        return project;
    }

    @Override
    public CreateProjectResponseDTO toRespons(Project project) {
        return new CreateProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getMaxEmployee(),
                project.getMinEmployee(),
                project.getTotalEmployee()
        );
    }


    @Override
    public UpdateProjectResponseDTO toUpdateProjectResponse(Project project) {
        return new UpdateProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getMaxEmployee(),
                project.getMinEmployee(),
                project.getTotalEmployee()
        );
    }

}
