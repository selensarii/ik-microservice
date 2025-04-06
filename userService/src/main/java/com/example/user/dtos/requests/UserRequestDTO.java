package com.example.user.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDTO {
    private String nickName;
    private String password;
}
