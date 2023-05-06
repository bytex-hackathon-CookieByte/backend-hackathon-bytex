package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class ChallengeResponseDto {

    private UUID id;

    private String title;

    private String description;

    private int price;

    private int adPrice;

    private long startTime;

    private UUID companyId;


    public ChallengeResponseDto(UUID id,
                                String title,
                                String description,
                                int price,
                                int adPrice,
                                long startTime,
                                UUID companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.adPrice = adPrice;
        this.startTime = startTime;
        this.companyId = companyId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAdPrice(int adPrice) {
        this.adPrice = adPrice;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public UUID getId() {
        return id;
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

    public long getStartTime() {
        return startTime;
    }

    public UUID getCompanyId() {
        return companyId;
    }
}
