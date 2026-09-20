package com.example.demo.controllers;

import com.example.demo.dto.GameCreateRequest;
import com.example.demo.dto.GameResponse;
import com.example.demo.services.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameResponse> createGame(
            @RequestBody GameCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(gameService.createGame(request));
    }

    @GetMapping
    public ResponseEntity<List<GameResponse>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> getGameById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                gameService.getGameById(id)
        );
    }

    @GetMapping("/steam/{steamAppId}")
    public ResponseEntity<GameResponse> getGameBySteamAppId(
            @PathVariable Long steamAppId
    ) {
        return ResponseEntity.ok(
                gameService.getGameBySteamAppId(steamAppId)
        );
    }
}