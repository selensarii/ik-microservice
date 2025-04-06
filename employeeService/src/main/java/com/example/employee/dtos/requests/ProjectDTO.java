package com.example.employee.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private UUID id;
    private String name;
    private Long maxEmployee;
    private Long minEmployee;
    private Long totalEmployee;
}
