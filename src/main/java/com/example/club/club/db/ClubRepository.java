package com.example.club.club.db;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClubRepository extends JpaRepository<ClubEntity, Long> {

    @EntityGraph(attributePaths = "userList")
    Optional<ClubEntity> findById(Long id);
}
