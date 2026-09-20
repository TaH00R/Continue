package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStatsResponse {

    private Long gamesOwned;
    private Long totalPlaytimeMinutes;
    private Long recentlyPlayedCount;
}