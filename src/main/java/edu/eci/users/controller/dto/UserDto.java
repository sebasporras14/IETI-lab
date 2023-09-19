package edu.eci.users.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

    String fullName;

    String email;

    public UserDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public UserDto(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}
