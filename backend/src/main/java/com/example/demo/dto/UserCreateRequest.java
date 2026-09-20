package com.example.demo.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {

    private String steamId;

    private String username;

    private String avatarUrl;
}

