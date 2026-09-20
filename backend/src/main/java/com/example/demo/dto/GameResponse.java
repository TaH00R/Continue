package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameResponse {

    private Long id;
    private Long steamAppId;
    private String name;
    private String headerImage;
}