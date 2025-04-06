package com.example.user.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class UpdateUserRequestDTO {

    private UUID id;
    private String nickName;
    private String password;
}
