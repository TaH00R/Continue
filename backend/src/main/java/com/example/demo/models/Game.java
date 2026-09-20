package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "steam_app_id", nullable = false, unique = true)
    private Long steamAppId;

    @Column(nullable = false)
    private String name;

    @Column(name = "header_image")
    private String headerImage;

    @OneToMany(
            mappedBy = "game",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<UserGame> users = new ArrayList<>();
}