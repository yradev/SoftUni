package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//ToDo:
@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Player findPlayerByEmail(String email);

    @Query("SELECT p " +
            "FROM Player p " +
            "JOIN p.stat s " +
            "WHERE p.birthDate BETWEEN :startDate AND :endDate " +
            "ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.lastName ASC")
    List<Player> findBestPlayers(LocalDate startDate,LocalDate endDate);
}
