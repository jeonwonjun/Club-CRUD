package com.example.club.club.db;

import com.example.club.user.db.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "club")
public class ClubEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_name", nullable = false, length = 50)
    private String clubName;

    @Column(name = "club_description", nullable = false, columnDefinition = "TEXT")
    private String clubDescription;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "club"
    )
    @Builder.Default
    private List<UserEntity> userList = List.of();
}
