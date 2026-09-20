package com.example.demo.services;

import com.example.demo.dto.GameCreateRequest;
import com.example.demo.dto.GameResponse;

import java.util.List;

public interface GameService {

    GameResponse createGame(GameCreateRequest request);

    GameResponse getGameById(Long id);

    GameResponse getGameBySteamAppId(Long steamAppId);

    List<GameResponse> getAllGames();
}