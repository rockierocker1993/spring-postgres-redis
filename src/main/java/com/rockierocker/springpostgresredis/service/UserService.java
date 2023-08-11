package com.rockierocker.springpostgresredis.service;


import com.rockierocker.springpostgresredis.dto.users.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto userDto);

    UserDto update(Long id,UserDto userDto);

    UserDto findById(Long id);

    Integer deleteById(Long id);

    List<UserDto> findAll();


}
