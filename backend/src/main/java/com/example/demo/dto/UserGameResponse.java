package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGameResponse {

    private Long id;
    private GameResponse game;
    private Integer playtimeMinutes;
    private LocalDateTime lastPlayed;
}