package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
    @NotBlank(message = "Username is required.")
    @Size(min=3, message = "Username must be at least 3 characters long.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min=8, message = "Password must be at least 8 characters long.")
    private String password;

    @NotBlank(message = "Firstname is required.")
    @Size(min=3, message = "Firstname must be at least 3 characters long.")
    private String firstname;

    @NotBlank(message = "Lastname is required.")
    @Size(min=3, message = "Lastname must be at least 1 character long.")
    private String lastname;

    @Email
    private String email;

    @NotBlank(message = "Phone number is required.")
    private String phone;
    @NotBlank
    private String avatar;


    private int tokens;

    public UserRequestDto(String username, String password, String firstname, String lastname, String email, String phone, int tokens, String avatar) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.tokens = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public String getAvatar() {
        return avatar;
    }
}
