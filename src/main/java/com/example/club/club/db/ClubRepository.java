package com.example.club.club.db;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;

public interface ClubRepository extends JpaRepository<Entity, Long> {
}
