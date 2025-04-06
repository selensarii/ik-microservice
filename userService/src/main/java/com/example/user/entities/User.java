package com.example.user.entities;

import com.example.user.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_users")
public class User extends BaseEntity {
    private String nickName;
    private String password;
}
