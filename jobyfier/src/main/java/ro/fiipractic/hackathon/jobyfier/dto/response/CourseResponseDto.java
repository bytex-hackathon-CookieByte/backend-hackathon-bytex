package ro.fiipractic.hackathon.jobyfier.dto.response;

import java.util.UUID;

public class CourseResponseDto {
    private UUID id;
    private String title;
    private int price;
    private String content;
    private UUID companyId;


    public CourseResponseDto(UUID id, String title, int price, String content, UUID companyId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.content = content;
        this.companyId = companyId;
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


}
