package com.example.club.club.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.club.model.ClubDto;
import com.example.club.club.model.ClubRequest;
import com.example.club.common.Api;
import com.example.club.common.Pagination;
import com.example.club.crud.CRUDAbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClubService extends CRUDAbstractService<ClubDto, ClubEntity> {

/*    private final ClubRepository clubRepository;
    private final ClubConverter clubConverter;

    // CREATE
    public ClubDto createClub(ClubRequest clubRequest) {
        var entity = ClubEntity.builder()
                .clubName(clubRequest.getClubName())
                .clubDescription(clubRequest.getClubDescription())
                .createdAt(LocalDateTime.now())
                .build();

        var saveEntity = clubRepository.save(entity);
        return clubConverter.toDto(saveEntity);
    }

    public ClubDto view(Long id) {
        var entity = clubRepository.findById(id).get();
        return clubConverter.toDto(entity);
    }

    public Api<List<ClubEntity>> all(Pageable pageable) {
        var list = clubRepository.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalPage(list.getTotalPages())
                .totalElements(list.getTotalElements())
                .build();

        var response = Api.<List<ClubEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();

        return response;
    }*/

}
