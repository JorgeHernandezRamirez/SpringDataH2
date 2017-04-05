package com.jorgehernandezramirez.spring.springboot.h2;

import com.jorgehernandezramirez.spring.springboot.h2.service.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class H2Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void initialization(){
        testRestTemplate.postForEntity("/user", new UserDto("jorge", "jorge"), String.class);
    }

    @Test
    public void shouldGetUserList() throws Exception {
        final ResponseEntity<List<UserDto>> userResponse = testRestTemplate.exchange("/user",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDto>>() {
                        });
        assertEquals(1, userResponse.getBody().size());
    }

    @Test
    public void shouldReturnInternalServerErrorWhenInsertAExistingUser() throws Exception {
        final ResponseEntity<String> responseEntity
                = testRestTemplate.postForEntity("/user", new UserDto("jorge", "jorge"), String.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}
