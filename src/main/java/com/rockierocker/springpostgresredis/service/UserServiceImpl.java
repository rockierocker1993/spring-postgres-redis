package com.rockierocker.springpostgresredis.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rockierocker.springpostgresredis.dto.users.UserDto;
import com.rockierocker.springpostgresredis.entity.User;
import com.rockierocker.springpostgresredis.exception.BadRequestException;
import com.rockierocker.springpostgresredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@EnableCaching
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService{

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        User user = objectMapper.convertValue(userDto,User.class);
        return objectMapper.convertValue(userRepository.save(user),UserDto.class);
    }

    @CacheEvict(key = "#id",value = "users")
    @Override
    public UserDto update(Long id,UserDto userDto) {
        User findById = userRepository.findById(id).orElseThrow(()->new BadRequestException("user not found"));
        User user = objectMapper.convertValue(userDto,User.class);
        user.setId(id);
        return objectMapper.convertValue(userRepository.save(user),UserDto.class);
    }

    @Cacheable(key = "#id",value = "users")
    @Override
    public UserDto findById(Long id) {
        return objectMapper.convertValue(userRepository.findById(id).orElseThrow(()->new BadRequestException("user not found")),UserDto.class);
    }

    @CacheEvict(key = "#id",value = "users")
    @Override
    public Integer deleteById(Long id) {
        User findById = userRepository.findById(id).orElseThrow(()->new BadRequestException("user not found"));
        findById.setDeleted(new Date());
        userRepository.save(findById);
        return 1;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return objectMapper.convertValue(users, new TypeReference<List<UserDto>>(){});
    }
}
