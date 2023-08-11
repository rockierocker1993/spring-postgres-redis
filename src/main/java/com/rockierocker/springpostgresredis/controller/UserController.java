package com.rockierocker.springpostgresredis.controller;

import com.rockierocker.springpostgresredis.dto.users.UserDto;
import com.rockierocker.springpostgresredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "")
    public UserDto create(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }

    @PutMapping(value = "/{id}")
    public UserDto update(@RequestBody UserDto userDto,@PathVariable("id")Long id){
        return userService.update(id,userDto);
    }

    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable("id")Long id){
        return userService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Integer deleteById(@PathVariable("id")Long id){
        return userService.deleteById(id);
    }

}
