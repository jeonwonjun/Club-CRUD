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
    @JsonIgnore
    private ClubEntity club;

    private String userName;

    private Integer userAge;

    private LocalDateTime registedAt;

}
