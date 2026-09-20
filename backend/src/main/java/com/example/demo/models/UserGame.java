package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_games",
        uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_game", columnNames = {"user_id", "game_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "playtime_minutes", nullable = false)
    private Integer playtimeMinutes;

    @Column(name = "last_played")
    private LocalDateTime lastPlayed;
}