package com.example.projectService.business.concretes;


import com.example.common.dto.AddProjectResponseDTO;
import com.example.common.dto.GetEmployeeCountResponseDTO;
import com.example.common.dto.GetEmployeeNamesResponseDTO;
import com.example.common.dto.GetEmployeeResponseDTO;
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final MapperService mapperService;
    private final RestTemplate restTemplate;

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll().stream().map(mapperService::toResponseDto).collect(Collectors.toList());
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
    public AddProjectResponseDTO getById(String id) {
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

    @Override
    public List<GetEmployeeNamesByProjectIdResponseDTO> getFindEmployeeNamesByProjectId(String projectId) {
        UUID projectUuid = UUID.fromString(projectId);

        String url = "http://localhost:9006/employees";

        ResponseEntity<List<GetEmployeeNamesResponseDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GetEmployeeNamesResponseDTO>>() {},
                projectUuid
        );

        List<GetEmployeeNamesResponseDTO> employeeNames = responseEntity.getBody();

        return employeeNames.stream()
                .map(employee -> new GetEmployeeNamesByProjectIdResponseDTO(employee.getFullName()))
                .collect(Collectors.toList());
    }


    @Override
    public GetCountEmployeesByProjectIdResponseDTO getCountEmployeesByProjectId(String projectId) {
        UUID projectUuid = UUID.fromString(projectId);

        ResponseEntity<GetEmployeeCountResponseDTO> responseEntity = restTemplate.exchange(
                "http://localhost:9006/employees",
                HttpMethod.GET,
                null,
                GetEmployeeCountResponseDTO.class,
                projectUuid
        );

        GetEmployeeCountResponseDTO employeeCountDTO = responseEntity.getBody();

        if (employeeCountDTO != null) {
            return new GetCountEmployeesByProjectIdResponseDTO(employeeCountDTO.getCount());
        } else {
            return new GetCountEmployeesByProjectIdResponseDTO(0L);
        }
    }

    @Override
    public List<GetFindEmployeesByProjectIdResponseDTO> getFindEmployeesByProjectId(String projectId) {

        String employeeServiceUrl = "http://localhost:9006/employees";

        ResponseEntity<List<GetEmployeeResponseDTO>> response = restTemplate.exchange(
                employeeServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        List<GetEmployeeResponseDTO> employeeResponseList = response.getBody();

        List<GetFindEmployeesByProjectIdResponseDTO> dtoList = new ArrayList<>();

        for (GetEmployeeResponseDTO empResponse : employeeResponseList) {
            GetFindEmployeesByProjectIdResponseDTO dto = new GetFindEmployeesByProjectIdResponseDTO(
                    empResponse.getFullName(),
                    empResponse.getPosition(),
                    empResponse.getIdentityNumber(),
                    empResponse.getSalary()
            );
            dtoList.add(dto);
        }

        return dtoList;
    }
}
