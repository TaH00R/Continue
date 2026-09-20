package com.example.demo.repositories;

import com.example.demo.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findBySteamAppId(Long steamAppId);

    boolean existsBySteamAppId(Long steamAppId);
}