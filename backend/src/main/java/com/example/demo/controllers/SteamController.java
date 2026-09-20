package com.example.demo.controllers;

import com.example.demo.clients.SteamApiClient;
import com.example.demo.dto.steam.SteamGamesResponse;
import com.example.demo.dto.steam.SteamPlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/steam")
@RequiredArgsConstructor
public class SteamController {

    private final SteamApiClient steamApiClient;

    @GetMapping("/user/{steamId}")
    public SteamPlayerResponse getUser(
            @PathVariable String steamId
    ) {
        return steamApiClient.getPlayerSummary(steamId);
    }

    @GetMapping("/games/{steamId}")
    public SteamGamesResponse getGames(
            @PathVariable String steamId
    ) {
        return steamApiClient.getOwnedGames(steamId);
    }
}