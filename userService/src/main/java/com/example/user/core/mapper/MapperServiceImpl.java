package com.example.user.core.mapper;

import com.example.user.entities.User;
import com.example.user.dtos.requests.CreateUserRequestDTO;
import com.example.user.dtos.responses.UserResponseDTO;
import com.example.user.dtos.responses.CreateUserResponseDTO;
import com.example.user.dtos.responses.UpdateUserResponseDTO;
import org.springframework.stereotype.Service;


@Service
public class MapperServiceImpl implements MapperService {

    @Override
    public UserResponseDTO toResponsed(User user) {
        UserResponseDTO responseDto = new UserResponseDTO();
        responseDto.setId(user.getId().toString());
        responseDto.setPassword(user.getPassword());
        responseDto.setNickName(user.getNickName());
        return responseDto;
    }

    @Override
    public UpdateUserResponseDTO toUpdateUserResponse(User user) {
        UpdateUserResponseDTO responseDto = new UpdateUserResponseDTO();
        responseDto.setId(user.getId());
        responseDto.setNickName(user.getNickName());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }
    @Override
    public User toUserEntity(CreateUserRequestDTO dto){
        User user = new User();
        user.setNickName(dto.getNickName());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public CreateUserResponseDTO toUserResponse(User user) {
        return new CreateUserResponseDTO(user.getId(), user.getNickName(), user.getPassword());
    }
}
