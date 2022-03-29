package com.example.football.repository;


import com.example.football.models.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//ToDo:
@Repository
public interface TownRepository extends JpaRepository<Town,Integer> {
    Town findTownByName(String name);
}
