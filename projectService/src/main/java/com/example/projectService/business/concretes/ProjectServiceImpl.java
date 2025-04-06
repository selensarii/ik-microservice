package com.example.projectService.business.concretes;


import com.example.projectService.business.abstracts.ProjectService;
import com.example.projectService.core.mapper.MapperService;
import com.example.projectService.core.utils.MessageConstant;
import com.example.projectService.dataAccess.ProjectRepository;
import com.example.projectService.dtos.request.CreateProjectRequestDTO;
import com.example.projectService.dtos.request.UpdateProjectRequestDTO;
import com.example.projectService.dtos.response.*;
import com.example.projectService.entities.Project;
import com.example.projectService.library.ProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final MapperService mapperService;

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll().stream().map(mapperService::toResponse).collect(Collectors.toList());
    }

    @Override
    public Project findById(String id) {
        UUID projectId = UUID.fromString(id);
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(MessageConstant.PROJECT_NOT_FOUND));
    }

    @Override
    public CreateProjectResponseDTO addProject(CreateProjectRequestDTO createProjectRequestDTO) {
        Project project = mapperService.toEntitys(createProjectRequestDTO);

        Project savedProject = projectRepository.save(project);
        return mapperService.toRespons(savedProject);
    }


    @Override
    public ProjectResponseDto getById(String id) {
        UUID projectId = UUID.fromString(id);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(MessageConstant.PROJECT_ID_NOT_FOUND));
        return  mapperService.toResponse(project);
    }

    @Override
    public UpdateProjectResponseDTO updateProject(UpdateProjectRequestDTO updateProjectRequestDTO) {
        UUID projectId = updateProjectRequestDTO.getId();
        Project existingProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(MessageConstant.PROJECT_NOT_FOUND));

        existingProject.setName(updateProjectRequestDTO.getName());
        existingProject.setMaxEmployee(updateProjectRequestDTO.getMaxEmployee());
        existingProject.setMinEmployee(updateProjectRequestDTO.getMinEmployee());
        existingProject.setTotalEmployee(updateProjectRequestDTO.getTotalEmployee());

        Project updatedProject = projectRepository.save(existingProject);
        return mapperService.toUpdateProjectResponse(updatedProject);
    }

    @Override
    public void deleteProject(String id) {
        UUID projectId = UUID.fromString(id);
        projectRepository.deleteById(projectId);
    }


}
