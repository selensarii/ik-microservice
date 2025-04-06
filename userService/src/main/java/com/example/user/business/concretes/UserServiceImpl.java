package com.example.user.business.concretes;

import com.example.user.core.mapper.MapperService;
import com.example.user.business.abstracts.UserService;
import com.example.user.core.utils.MessageConstant;
import com.example.user.dataAccess.UserRepository;
import com.example.user.dtos.requests.CreateUserRequestDTO;
import com.example.user.dtos.requests.UpdateUserRequestDTO;
import com.example.user.dtos.responses.CreateUserResponseDTO;
import com.example.user.dtos.responses.UpdateUserResponseDTO;
import com.example.user.dtos.responses.UserResponseDTO;
import com.example.user.entities.User;
import com.example.user.library.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperService mapperService;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(mapperService::toResponsed).toList();
    }

    @Override
    public CreateUserResponseDTO addUser(CreateUserRequestDTO createUserRequestDTO) {
        User user = mapperService.toUserEntity(createUserRequestDTO);
        User savedUser = userRepository.save(user);
        return mapperService.toUserResponse(savedUser);
    }

    @Override
    public UserResponseDTO getById(String id) {
        UUID userId = UUID.fromString(id);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(MessageConstant.USER_NOT_FOUND));
        return mapperService.toResponsed(user);
    }

    @Override
    public UpdateUserResponseDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO) {
        UUID userId = updateUserRequestDTO.getId();

        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setNickName(updateUserRequestDTO.getNickName());
                    existingUser.setPassword(updateUserRequestDTO.getPassword());

                    return userRepository.save(existingUser);
                })
                .map(mapperService::toUpdateUserResponse)
                .orElseThrow(() -> new UserNotFoundException(MessageConstant.USER_NOT_FOUND));
    }

    @Override
    public void deleteUser(String id) {
        UUID userId = UUID.fromString(id);
        userRepository.deleteById(userId);
    }
}
