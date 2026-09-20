package com.example.demo.dto.steam;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamPlayer {

    private String steamid;
    private String personaname;
    private String profileurl;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private Integer personastate;
    private String realname;
    private String loccountrycode;
}