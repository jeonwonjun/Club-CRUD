package com.example.club.club.controller;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.club.model.ClubDto;
import com.example.club.club.model.ClubRequest;
import com.example.club.club.service.ClubService;
import com.example.club.common.Api;
import com.example.club.crud.CRUDAbstractApiController;
import com.example.club.user.db.UserEntity;
import com.example.club.user.model.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/club")
@RequiredArgsConstructor
public class ClubApiController {

    private final ClubService clubService;
    private final ClubRepository clubRepository;

    // CREATE
    @PostMapping("")
    public ClubDto create(@Valid @RequestBody ClubRequest clubRequest) {
        return clubService.createClub(clubRequest);
    }

    @PutMapping("/{id}") // Maps to PUT /users/{id}
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClubDto> update(@PathVariable Long id, @RequestBody ClubRequest clubRequest) {

        var result = this.clubService.updateClub(id,
                clubRequest.getClubName(),
                clubRequest.getClubDescription());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/id/{id}")
    public ClubEntity view(
            @PathVariable Long id
    ){
        return clubService.view(id);
    }

    @GetMapping("/ids/{id}")
    public List<ClubEntity> all(
            @PathVariable Long id
    ){
        return clubRepository.findAll();
    }

    // delete
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }

    // 전체 동아리 조회
    @GetMapping("/all")
    public Api<List<ClubEntity>> list(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return clubService.all(pageable);
    }

}
