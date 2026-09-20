package com.example.demo.services.impl;

import com.example.demo.dto.UserCreateRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserCreateRequest request) {

        if (userRepository.existsBySteamId(request.getSteamId())) {
            throw new RuntimeException(
                    "User already exists with Steam ID: "
                            + request.getSteamId()
            );
        }

        User user = User.builder()
                .steamId(request.getSteamId())
                .username(request.getUsername())
                .avatarUrl(request.getAvatarUrl())
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with ID: " + id
                        )
                );

        return mapToResponse(user);
    }

    @Override
    public UserResponse getUserBySteamId(String steamId) {

        User user = userRepository.findBySteamId(steamId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with Steam ID: " + steamId
                        )
                );

        return mapToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .steamId(user.getSteamId())
                .username(user.getUsername())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
}
