package com.example.user.controller;

import com.example.user.business.abstracts.UserService;
import com.example.user.core.utils.MessageConstant;
import com.example.user.dtos.requests.CreateUserRequestDTO;
import com.example.user.dtos.requests.UpdateUserRequestDTO;
import com.example.user.dtos.responses.CreateUserResponseDTO;
import com.example.user.dtos.responses.UpdateUserResponseDTO;
import com.example.user.dtos.responses.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public CreateUserResponseDTO addUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        return userService.addUser(createUserRequestDTO);
    }

    @GetMapping("/v1/userId/{userId}")
    public UserResponseDTO getById(@PathVariable(value = "userId") String userId) {
        return userService.getById(userId);
    }

    @PutMapping("/v1/userId")
    public UpdateUserResponseDTO updateUser(@RequestBody UpdateUserRequestDTO updateUserRequestDTO) {
        return userService.updateUser(updateUserRequestDTO);
    }

    @DeleteMapping("/v1/userId/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "userId") String userId){
        userService.deleteUser(userId);
        String message = MessageConstant.USER_DELETED_SUCCESSFULLY+ userId;
        return ResponseEntity.ok(message);
    }
}
