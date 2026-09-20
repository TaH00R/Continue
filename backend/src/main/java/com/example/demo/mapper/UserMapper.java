package com.example.demo.mapper;

import com.example.demo.dto.UserResponse;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .steamId(user.getSteamId())
                .username(user.getUsername())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
}