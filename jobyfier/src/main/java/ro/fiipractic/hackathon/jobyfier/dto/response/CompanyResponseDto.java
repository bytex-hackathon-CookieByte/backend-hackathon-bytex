package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class CompanyResponseDto {

    private String type = "company";
    private UUID id;

    private String username;
    private String name;
    private String email;
    private String phone;
    private int tokens;

    public CompanyResponseDto(UUID id, String username, String name, String email, String phone, int tokens) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.tokens = tokens;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
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
}
