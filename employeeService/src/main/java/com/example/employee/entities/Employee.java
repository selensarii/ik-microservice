package com.example.employee.entities;

import com.example.employee.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
public class Employee extends BaseEntity {  //

    private String fullName;
    private String position;
    private String identityNumber;
    private String salary;
    private UUID projectId;
}