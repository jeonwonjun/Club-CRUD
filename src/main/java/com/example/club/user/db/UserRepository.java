package com.example.club.user.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // 특정 동아리에 속한 모든 회원 조회
    List<UserEntity> findAllByClubIdOrderById(Long clubId);
}
