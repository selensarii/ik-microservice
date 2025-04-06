package com.example.user.business.abstracts;

import com.example.user.dtos.requests.CreateUserRequestDTO;
import com.example.user.dtos.requests.UpdateUserRequestDTO;
import com.example.user.dtos.responses.CreateUserResponseDTO;
import com.example.user.dtos.responses.UpdateUserResponseDTO;
import com.example.user.dtos.responses.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getById(String id);
    void deleteUser(String id);


    UpdateUserResponseDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO);
    CreateUserResponseDTO addUser(CreateUserRequestDTO createUserRequestDTO);

}
