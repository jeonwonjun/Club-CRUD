package com.example.club.user.controller;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.model.ClubDto;
import com.example.club.club.model.ClubRequest;
import com.example.club.crud.CRUDAbstractApiController;
import com.example.club.user.db.UserEntity;
import com.example.club.user.model.UserDto;
import com.example.club.user.model.UserRequest;
import com.example.club.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    // create
    @PostMapping("")
    public UserDto create(
            @Valid
            @RequestBody UserRequest userRequest
    ){
        return userService.createUser(userRequest);
    }

    @PutMapping("/{id}") // Maps to PUT /users/{id}
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserRequest userRequest) {

        var result = this.userService.updateUser(id,
                userRequest.getUserName(),
                userRequest.getUserAge());
        return ResponseEntity.ok(result);
    }

    // delete
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
