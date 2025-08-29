package com.example.club.user.service;

import com.example.club.crud.CRUDAbstractApiController;
import com.example.club.user.db.UserEntity;
import com.example.club.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserConverter extends CRUDAbstractApiController<UserDto, UserEntity> {

}
