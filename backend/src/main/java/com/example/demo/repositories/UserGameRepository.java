package com.example.demo.repositories;

import com.example.demo.models.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserGameRepository extends JpaRepository<UserGame, Long> {

    List<UserGame> findByUserId(Long userId);

    List<UserGame> findByGameId(Long gameId);

    Optional<UserGame> findByUserIdAndGameId(
            Long userId,
            Long gameId
    );

    boolean existsByUserIdAndGameId(
            Long userId,
            Long gameId
    );
}