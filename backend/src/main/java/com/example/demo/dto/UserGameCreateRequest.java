package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGameCreateRequest {

    private Long userId;
    private Long gameId;
    private Integer playtimeMinutes;
    private LocalDateTime lastPlayed;
}