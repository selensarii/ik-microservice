package com.example.projectService.entities;


import com.example.projectService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "project")
public class Project extends BaseEntity {

    private String name;
    private Long maxEmployee;
    private Long minEmployee;
    private Long totalEmployee;

}
