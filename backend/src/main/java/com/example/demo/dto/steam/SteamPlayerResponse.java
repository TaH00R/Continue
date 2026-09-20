package com.example.demo.dto.steam;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamPlayerResponse {

    private Response response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private List<SteamPlayer> players;
    }
}