package edu.eci.users.service;

import edu.eci.users.controller.dto.UserDto;
import edu.eci.users.data.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(String id);

    User createUser(UserDto userDto);

    User updateUser(UserDto userDto, String id);

    boolean deleteUser(String id);
}
