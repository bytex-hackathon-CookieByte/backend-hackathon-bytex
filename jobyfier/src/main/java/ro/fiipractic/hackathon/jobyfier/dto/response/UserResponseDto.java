package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class UserResponseDto {

    private String type = "user";
    private UUID id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private int tokens;
    private String avatar;

    public UserResponseDto(UUID id,
                           String username,
                           String firstname,
                           String lastname,
                           String email,
                           String phone,
                           int tokens, String avatar) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.tokens = tokens;
        this.avatar = avatar;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getTokens() {
        return tokens;
    }

    public String getType() {
        return type;
    }

    public String getAvatar() {
        return avatar;
    }
}
