package com.example.demo.services.impl;

import com.example.demo.dto.UserGameCreateRequest;
import com.example.demo.dto.UserGameResponse;
import com.example.demo.models.Game;
import com.example.demo.models.User;
import com.example.demo.models.UserGame;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.UserGameRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserGameService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGameServiceImpl implements UserGameService {

    private final UserGameRepository userGameRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Override
    public UserGameResponse addGameToUser(
            UserGameCreateRequest request
    ) {

        if (userGameRepository.existsByUserIdAndGameId(
                request.getUserId(),
                request.getGameId()
        )) {
            throw new RuntimeException("Game already added to user");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(() ->
                        new RuntimeException("Game not found")
                );

        UserGame userGame = UserGame.builder()
                .user(user)
                .game(game)
                .playtimeMinutes(request.getPlaytimeMinutes())
                .lastPlayed(request.getLastPlayed())
                .build();

        return mapToResponse(
                userGameRepository.save(userGame)
        );
    }

    @Override
    public List<UserGameResponse> getGamesForUser(Long userId) {

        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        return userGameRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public UserGameResponse getUserGame(
            Long userId,
            Long gameId
    ) {

        UserGame userGame =
                userGameRepository.findByUserIdAndGameId(
                        userId,
                        gameId
                ).orElseThrow(() ->
                        new RuntimeException(
                                "User does not have this game"
                        )
                );

        return mapToResponse(userGame);
    }

    private UserGameResponse mapToResponse(UserGame userGame) {

        return UserGameResponse.builder()
                .id(userGame.getId())
                .userId(userGame.getUser().getId())
                .gameId(userGame.getGame().getId())
                .playtimeMinutes(userGame.getPlaytimeMinutes())
                .lastPlayed(userGame.getLastPlayed())
                .build();
    }
}