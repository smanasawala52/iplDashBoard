package com.example.ipldashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ipldashboard.model.NFTMetadata;

@Repository
public interface NFTRepository extends JpaRepository<NFTMetadata, Long> {
	NFTMetadata getByName(String name);
}
