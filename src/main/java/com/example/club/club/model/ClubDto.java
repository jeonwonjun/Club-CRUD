package com.example.club.club.model;

import com.example.club.user.model.UserDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClubDto {
    private Long id;
    private String clubName;
    private String clubDescription;
    private LocalDateTime createdAt;

    private List<UserDto> userList = List.of();
}
