package com.example.user.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserResponseDTO {
    private UUID id;
    private String nickName;
    private String password;
}
