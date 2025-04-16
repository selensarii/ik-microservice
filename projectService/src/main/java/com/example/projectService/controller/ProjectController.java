package com.example.projectService.controller;

import com.example.common.dto.AddProjectResponseDTO;
import com.example.projectService.business.abstracts.ProjectService;
import com.example.projectService.core.utils.MessageConstant;
import com.example.projectService.dtos.request.CreateProjectRequestDTO;
import com.example.projectService.dtos.request.UpdateProjectRequestDTO;
import com.example.projectService.dtos.response.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public CreateProjectResponseDTO addProject(@RequestBody CreateProjectRequestDTO createProjectRequestDTO) {
        return projectService.addProject(createProjectRequestDTO);
    }

    @GetMapping("/v1/projectId/{projectId}")
    public AddProjectResponseDTO getById(@PathVariable String projectId) {
        return projectService.getById(projectId);
    }

    @PutMapping("/v1/projectId")
    public UpdateProjectResponseDTO updateProject(@RequestBody UpdateProjectRequestDTO updateProjectRequestDTO) {
        return projectService.updateProject(updateProjectRequestDTO);
    }

    @DeleteMapping("/v1/projectId/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable(name = "projectId") String projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok(MessageConstant.PROJECT_DELETED_SUCCESSFULLY+ projectId);
    }

    @GetMapping("/v1/employeeNames/projectId/{projectId}")
    public List<GetEmployeeNamesByProjectIdResponseDTO> getEmployeeNamesByProjectId(@PathVariable String projectId) {
        return projectService.getFindEmployeeNamesByProjectId(projectId);
    }

    @GetMapping("/v1/employeeCount/projectId/{projectId}")
    public GetCountEmployeesByProjectIdResponseDTO getCountEmployeesByProjectId(@PathVariable String projectId) {
        return projectService.getCountEmployeesByProjectId(projectId);
    }

    @GetMapping("/v1/employeesAll/projectId/{projectId}")
    public List<GetFindEmployeesByProjectIdResponseDTO> getFindEmployeesByProjectId(@PathVariable String projectId) {
        return projectService.getFindEmployeesByProjectId(projectId);
    }


}
