package edu.eci.users.data;

import edu.eci.users.controller.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "users")
public class User {

    @Id
    String id;
    String fullName;
    String email;
    Date createdAt;
    Date modifiedAt;

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.createdAt = new Date();
    }

    public void updateInfo(UserDto userDto) {
        this.fullName = userDto.getFullName();
        this.email = userDto.getEmail();
        this.modifiedAt = new Date();
    }
}
