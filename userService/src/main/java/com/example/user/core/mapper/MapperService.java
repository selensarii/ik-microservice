package com.example.user.core.mapper;

import com.example.user.dtos.requests.CreateUserRequestDTO;
import com.example.user.dtos.responses.UserResponseDTO;
import com.example.user.dtos.responses.CreateUserResponseDTO;
import com.example.user.dtos.responses.UpdateUserResponseDTO;
import com.example.user.entities.User;

public interface MapperService {
    User toUserEntity(CreateUserRequestDTO dto);
    UserResponseDTO toResponsed(User user);
    UpdateUserResponseDTO toUpdateUserResponse(User user);
    CreateUserResponseDTO toUserResponse(User user);

}
