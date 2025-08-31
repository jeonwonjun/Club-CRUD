package com.example.club.user.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.club.model.ClubDto;
import com.example.club.crud.CRUDAbstractService;
import com.example.club.user.db.UserEntity;
import com.example.club.user.db.UserRepository;
import com.example.club.user.model.UserDto;
import com.example.club.user.model.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService extends CRUDAbstractService<UserEntity, Long> {
    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final UserConverter userConverter;

    public UserDto createUser(
            UserRequest userRequest
    ) {

        // 1. UserRequest에서 clubId를 가져옵니다.
        Long clubId = userRequest.getClubId();

        // 2. clubId를 사용하여 ClubEntity 객체를 데이터베이스에서 조회합니다.
        // 만약 해당 Club이 존재하지 않으면 예외를 발생시킵니다.
        ClubEntity clubEntity = clubRepository.findById(clubId)
                .orElseThrow(() -> new NoSuchElementException("Club not found with ID: " + clubId));

        var entity = UserEntity.builder()
                .club(clubEntity)
                .userName(userRequest.getUserName())
                .userAge(userRequest.getUserAge())
                .registedAt(LocalDateTime.now())
                .build();

        var saveEntity = userRepository.save(entity);
        return userConverter.toDto(saveEntity);
    }

    public UserDto updateUser(Long id, String name, Integer age) {
        // Ensure the ID from the URL matches the ID in the request body for consistency
        // userEntity.setId(id); // You might want to do this to ensure consistency

        // First, retrieve the existing entity
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));

        existingUser.setUserName(Strings.isEmpty(name) ?
                existingUser.getUserName() : name);

        existingUser.setUserAge(age == null ?
                existingUser.getUserAge() : age);

        var updated = this.userRepository.save(existingUser);
        return userConverter.toDto(updated);

    }

    // delete
    public void deleteUser(Long id) {
        if (!clubRepository.existsById(id)) {
            throw new NoSuchElementException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

/*    public List<UserEntity> findAllById(Long clubId){
        return UserRepository.findAllById(clubId);
    }*/
}
