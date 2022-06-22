package com.example.ipldashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ipldashboard.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	Player getByName(String name);
}
