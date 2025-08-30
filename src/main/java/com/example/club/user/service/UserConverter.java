package com.example.club.user.service;

import com.example.club.club.db.ClubRepository;
import com.example.club.crud.CRUDAbstractApiController;
import com.example.club.crud.Converter;
import com.example.club.user.db.UserEntity;
import com.example.club.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserConverter implements Converter<UserDto, UserEntity> {

    private final ClubRepository clubRepository;
    @Override
    public UserDto toDto(UserEntity userEntity) {

        UserDto.builder()
                .userId(userEntity.getId())
                .clubId(userEntity.getClub().getId())
                .userName(userEntity.getUserName())
                .registedAt(userEntity.getRegistedAt())
                .build();

        return null;
    }

    @Override
    public UserEntity toEntity(UserDto userDto) {
        var clubEntity = clubRepository.findById(userDto.getClubId());

        return UserEntity.builder()
                .id(userDto.getClubId()) // null: save, not null: update
                .club(clubEntity.orElseGet(()-> null))
                .userName(userDto.getUserName())
                .registedAt((userDto.getRegistedAt() != null) ? userDto.getRegistedAt() : LocalDateTime.now())
                .build();
    }
}
