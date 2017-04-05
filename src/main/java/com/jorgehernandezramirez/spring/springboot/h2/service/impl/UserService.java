package com.jorgehernandezramirez.spring.springboot.h2.service.impl;

import com.jorgehernandezramirez.spring.springboot.h2.dao.entity.UserEntity;
import com.jorgehernandezramirez.spring.springboot.h2.dao.repository.UserRepository;
import com.jorgehernandezramirez.spring.springboot.h2.service.api.IUserService;
import com.jorgehernandezramirez.spring.springboot.h2.service.dto.UserDto;
import com.jorgehernandezramirez.spring.springboot.h2.service.exception.UserAlreadyExistsException;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    public UserService(){
         //Para Spring
    }

    @Override
    public List<UserDto> getUsers() {
        final List<UserDto> userDtoList = new ArrayList<UserDto>();
        userRepository.findAll().forEach(userEntity -> {
            userDtoList.add(mapper.map(userEntity, UserDto.class));
        });
        return userDtoList;
    }

    @Override
    public void insertUser(final UserDto userDto) {
        if(userRepository.findOne(userDto.getUsername()) != null){
            throw new UserAlreadyExistsException();
        }
        userRepository.save(mapper.map(userDto, UserEntity.class));
    }
}
