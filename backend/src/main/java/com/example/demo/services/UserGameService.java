package com.example.demo.services;

import com.example.demo.dto.UserGameCreateRequest;
import com.example.demo.dto.UserGameResponse;

import java.util.List;

public interface UserGameService {

    UserGameResponse addGameToUser(
            UserGameCreateRequest request
    );

    List<UserGameResponse> getGamesForUser(Long userId);

    UserGameResponse getUserGame(
            Long userId,
            Long gameId
    );
}