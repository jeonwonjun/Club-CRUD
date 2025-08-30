package com.example.club.user.db;

import com.example.club.club.db.ClubEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK → Club
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private ClubEntity club;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_age", nullable = false)
    private Integer userAge;

    @Column(name = "registed_at", nullable = false)
    private LocalDateTime registedAt;

}
