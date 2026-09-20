package com.example.demo.services.impl;

import com.example.demo.dto.GameCreateRequest;
import com.example.demo.dto.GameResponse;
import com.example.demo.models.Game;
import com.example.demo.repositories.GameRepository;
import com.example.demo.services.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public GameResponse createGame(GameCreateRequest request) {

        if (gameRepository.existsBySteamAppId(request.getSteamAppId())) {
            throw new RuntimeException("Game already exists");
        }

        Game game = Game.builder()
                .steamAppId(request.getSteamAppId())
                .name(request.getName())
                .headerImage(request.getHeaderImage())
                .build();

        return mapToResponse(gameRepository.save(game));
    }

    @Override
    public GameResponse getGameById(Long id) {

        Game game = gameRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Game not found")
                );

        return mapToResponse(game);
    }

    @Override
    public GameResponse getGameBySteamAppId(Long steamAppId) {

        Game game = gameRepository.findBySteamAppId(steamAppId)
                .orElseThrow(() ->
                        new RuntimeException("Game not found")
                );

        return mapToResponse(game);
    }

    @Override
    public List<GameResponse> getAllGames() {

        return gameRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private GameResponse mapToResponse(Game game) {

        return GameResponse.builder()
                .id(game.getId())
                .steamAppId(game.getSteamAppId())
                .name(game.getName())
                .headerImage(game.getHeaderImage())
                .build();
    }
}