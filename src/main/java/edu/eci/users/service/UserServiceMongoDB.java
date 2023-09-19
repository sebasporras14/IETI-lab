package edu.eci.users.service;

import edu.eci.users.controller.dto.UserDto;
import edu.eci.users.data.User;
import edu.eci.users.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService {


    private final UserRepository userRepository;


    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto.getFullName(), userDto.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserDto userDto, String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().updateInfo(userDto);
            userRepository.save(user.get());
        }
        return user.get();
    }

    @Override
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

