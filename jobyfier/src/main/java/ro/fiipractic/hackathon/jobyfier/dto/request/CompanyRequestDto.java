package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CompanyRequestDto {
    @NotBlank
    @Size(min=3, message = "Username must be at least 3 characters long.")
    private String username;
    @NotBlank(message = "Company name is required.")
    @Size(min=3, message = "Company name must be at least 3 characters long.")
    private String name;
    @NotBlank(message = "Password is required.")
    @Size(min=8, message = "Password must be at least 8 characters long.")
    private String password;
    @Email
    private String email;

    @NotBlank(message = "Phone number is required.")
    @Size(min=10,max=10)
    private String phone;
    private int tokens;

    public CompanyRequestDto(String username, String name, String password, String email, String phone, int tokens) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.tokens = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
