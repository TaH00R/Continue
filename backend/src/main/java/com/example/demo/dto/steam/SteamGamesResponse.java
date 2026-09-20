package com.example.demo.dto.steam;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamGamesResponse {

    private Response response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private Integer game_count;
        private List<SteamGame> games;
    }
}