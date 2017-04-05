package com.jorgehernandezramirez.spring.springboot.h2.service.api;

import com.jorgehernandezramirez.spring.springboot.h2.service.dto.UserDto;

import java.util.List;

/**
 * Api de usuarios
 */
public interface IUserService {

    /**
     * Método que debe devolver la lista de usuarios en el sistema
     * @return
     */
    List<UserDto> getUsers();

    /**
     * Método que debe insertar a un usuario en el sistema.
     * En caso de existir ya el usuario se devuelve la excepción UserAlreadyExistsException
     * @param userDto
     */
    void insertUser(final UserDto userDto);
}
