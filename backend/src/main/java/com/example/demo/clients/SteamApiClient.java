package com.example.demo.clients;

import com.example.demo.dto.steam.SteamGamesResponse;
import com.example.demo.dto.steam.SteamPlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class SteamApiClient {

    private final WebClient steamWebClient;

    @Value("${steam.api.key}")
    private String steamApiKey;

    public SteamPlayerResponse getPlayerSummary(String steamId) {

        return steamWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/ISteamUser/GetPlayerSummaries/v0002/")
                        .queryParam("key", steamApiKey)
                        .queryParam("steamids", steamId)
                        .build())
                .retrieve()
                .bodyToMono(SteamPlayerResponse.class)
                .block();
    }

    public SteamGamesResponse getOwnedGames(String steamId) {

        return steamWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/IPlayerService/GetOwnedGames/v0001/")
                        .queryParam("key", steamApiKey)
                        .queryParam("steamid", steamId)
                        .queryParam("include_appinfo", true)
                        .queryParam("include_played_free_games", true)
                        .build())
                .retrieve()
                .bodyToMono(SteamGamesResponse.class)
                .block();
    }
}