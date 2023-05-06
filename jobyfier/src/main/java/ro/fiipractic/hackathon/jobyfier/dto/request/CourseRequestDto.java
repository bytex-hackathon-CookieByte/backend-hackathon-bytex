package ro.fiipractic.hackathon.jobyfier.dto.request;

import jakarta.validation.constraints.NotBlank;
import ro.fiipractic.hackathon.jobyfier.model.Company;

public class CourseRequestDto {
    @NotBlank
    private String title;
    @NotBlank(message = "Course price is required.")
    private int price;
    @NotBlank(message = "Course content is required.")
    private String content;
    @NotBlank(message = "Company is required.")
    private Company company;

    public CourseRequestDto(String title, int price, String content, Company company) {
        this.title = title;
        this.price = price;
        this.content = content;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
