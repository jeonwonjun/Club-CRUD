package com.example.club.club.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.model.ClubDto;
import com.example.club.crud.Converter;
import com.example.club.user.db.UserRepository;
import com.example.club.user.service.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubConverter implements Converter<ClubDto, ClubEntity> {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public ClubDto toDto(ClubEntity clubEntity) {

        var userList = clubEntity.getUserList()
                .stream()
                .map(userConverter::toDto)
                .collect(Collectors.toList());


        return ClubDto.builder()
                .id(clubEntity.getId())
                .clubName(clubEntity.getClubName())
                .clubDescription(clubEntity.getClubDescription())
                .createdAt(clubEntity.getCreatedAt())
                .userList(userList)
                .build();
    }

    @Override
    public ClubEntity toEntity(ClubDto clubDto) {
        var userEntity = userRepository.findById(clubDto.getId());

        return ClubEntity.builder()
                .id(clubDto.getId()) // null: save, not null: update
                .clubName(clubDto.getClubName())
                .createdAt((clubDto.getCreatedAt() != null) ? clubDto.getCreatedAt() : LocalDateTime.now())
                .build();
    }

}
