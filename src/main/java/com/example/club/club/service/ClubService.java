package com.example.club.club.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.club.model.ClubDto;
import com.example.club.club.model.ClubRequest;
import com.example.club.common.Api;
import com.example.club.common.Pagination;
import com.example.club.crud.CRUDAbstractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClubService extends CRUDAbstractService<ClubEntity, Long> {

    private final ClubRepository clubRepository;
    private final ClubConverter clubConverter;

    public ClubService(ClubRepository clubRepository, ClubConverter clubConverter){
        this.clubRepository = clubRepository;
        this.clubConverter = clubConverter;
    }

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

    public ClubDto updateClub(Long id, String name, String description) {
        // Ensure the ID from the URL matches the ID in the request body for consistency
        // userEntity.setId(id); // You might want to do this to ensure consistency

        // First, retrieve the existing entity
        ClubEntity existingClub = clubRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Club not found with ID: " + id));

        existingClub.setClubName(Strings.isEmpty(name) ?
                existingClub.getClubName() : name);
        existingClub.setClubDescription(Strings.isEmpty(description) ?
                existingClub.getClubDescription() : description);

        var updated = this.clubRepository.save(existingClub);
        return clubConverter.toDto(updated);

    }

    public ClubEntity view(Long id) {
        var entity = clubRepository.findById(id).get();
        return entity;
    }

    public ClubEntity save(ClubEntity club) {
        // save
        return clubRepository.save(club);
    }

    // delete
    public void deleteClub(Long id) {
        if (!clubRepository.existsById(id)) {
            throw new NoSuchElementException("Club not found with ID: " + id);
        }
        clubRepository.deleteById(id);
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
    }

}
