package com.jorgehernandezramirez.spring.springboot.h2;

import com.jorgehernandezramirez.spring.springboot.h2.dao.entity.UserEntity;
import com.jorgehernandezramirez.spring.springboot.h2.dao.repository.UserRepository;
import com.jorgehernandezramirez.spring.springboot.h2.service.api.IUserService;
import com.jorgehernandezramirez.spring.springboot.h2.service.dto.UserDto;
import com.jorgehernandezramirez.spring.springboot.h2.service.exception.UserAlreadyExistsException;
import org.apache.commons.collections.IteratorUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class H2DataJpaTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void initialization(){
        userRepository.save(new UserEntity("jorge", "1234"));
    }

    @Test
    public void shouldGetUserList(){
        assertEquals(1, IteratorUtils.toList(userRepository.findAll().iterator()).size());
    }
}
