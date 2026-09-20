package com.example.demo.services;

import com.example.demo.dto.UserCreateRequest;
import com.example.demo.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserCreateRequest request);
    UserResponse getUserById(Long id);
    UserResponse getUserBySteamId(String steamId);
    List<UserResponse> getAllUsers();
}

