package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class CourseResponseDto {
    private UUID id;
    private String title;
    private int price;
    private int prize;
    private String content;
    private CompanyResponseDto company;


    public CourseResponseDto(UUID id, String title, int price, int prize, String content, CompanyResponseDto company) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.prize = prize;
        this.content = content;
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CompanyResponseDto getCompany() {
        return company;
    }

    public void setCompany(CompanyResponseDto company) {
        this.company = company;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
