package com.example.demo.clients;

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

    public String getPlayerSummary(String steamId) {

        return steamWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/ISteamUser/GetPlayerSummaries/v0002/")
                        .queryParam("key", steamApiKey)
                        .queryParam("steamids", steamId)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getOwnedGames(String steamId) {

        return steamWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/IPlayerService/GetOwnedGames/v0001/")
                        .queryParam("key", steamApiKey)
                        .queryParam("steamid", steamId)
                        .queryParam("include_appinfo", true)
                        .queryParam("include_played_free_games", true)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}