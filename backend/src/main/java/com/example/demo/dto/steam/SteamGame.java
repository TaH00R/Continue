package com.example.demo.dto.steam;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamGame {

    private Long appid;
    private String name;

    private Integer playtime_forever;
    private Integer playtime_windows_forever;
    private Integer playtime_mac_forever;
    private Integer playtime_linux_forever;
    private Integer playtime_deck_forever;

    private Long rtime_last_played;
}