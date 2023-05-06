package ro.fiipractic.hackathon.jobyfier.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ChallengeRequestDto {

    @NotNull
    private UUID companyId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull
    private int price;

    @NotNull
    private int adPrice;

    @NotBlank
    private String startTime;

    public ChallengeRequestDto(UUID companyId, String title, String description, int price, int adPrice, String startTime) {
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.adPrice = adPrice;
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getAdPrice() {
        return adPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public UUID getCompanyId() {
        return companyId;
    }
}
