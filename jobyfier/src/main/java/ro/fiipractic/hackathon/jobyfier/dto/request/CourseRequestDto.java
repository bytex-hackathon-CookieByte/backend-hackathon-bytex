package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CourseRequestDto {
    @NotBlank
    private String title;
    @NotNull(message = "Course price is required.")
    private int price;
    @NotBlank(message = "Course content is required.")
    private String content;
    @NotNull
    private UUID companyId;

    public CourseRequestDto(String title, int price, String content, UUID companyId) {
        this.title = title;
        this.price = price;
        this.content = content;
        this.companyId = companyId;
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

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

}
