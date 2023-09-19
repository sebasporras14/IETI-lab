package edu.eci.users.service;

import edu.eci.users.controller.dto.UserDto;
import edu.eci.users.data.User;

import java.util.HashMap;
import java.util.Optional;

public class HashMapUserService implements UserService {


    private final HashMap<String, User> users = new HashMap<String, User>();

    @Override
    public Optional<User> getUserById(String id) {
        if (users.containsKey(id)) {
            return Optional.of(users.get(id));
        }
        return Optional.empty();
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User( userDto.getFullName(), userDto.getEmail());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(UserDto userDto, String id) {
        String key = String.valueOf(Integer.valueOf(id) - 1);
        if (users.containsKey(key)) {
            User user = users.get(key);
            user.updateInfo(userDto);
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }
}
