package com.example.demo.controllers;

import com.example.demo.dto.UserGameCreateRequest;
import com.example.demo.dto.UserGameResponse;
import com.example.demo.services.UserGameService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-games")
@RequiredArgsConstructor
public class UserGameController {

    private final UserGameService userGameService;

    @PostMapping
    public ResponseEntity<UserGameResponse> addGameToUser(
            @RequestBody UserGameCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userGameService.addGameToUser(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserGameResponse>> getGamesForUser(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(
                userGameService.getGamesForUser(userId)
        );
    }

    @GetMapping("/user/{userId}/game/{gameId}")
    public ResponseEntity<UserGameResponse> getUserGame(
            @PathVariable Long userId,
            @PathVariable Long gameId
    ) {
        return ResponseEntity.ok(
                userGameService.getUserGame(userId, gameId)
        );
    }
}