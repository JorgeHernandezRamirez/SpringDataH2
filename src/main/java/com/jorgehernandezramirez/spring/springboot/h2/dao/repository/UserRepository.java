package com.jorgehernandezramirez.spring.springboot.h2.dao.repository;

import com.jorgehernandezramirez.spring.springboot.h2.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    List<UserEntity> findByUsername(String username);
}
