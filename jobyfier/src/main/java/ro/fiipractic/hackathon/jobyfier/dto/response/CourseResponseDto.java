package ro.fiipractic.hackathon.jobyfier.dto.response;

import ro.fiipractic.hackathon.jobyfier.model.Course;

import java.util.UUID;

public class CourseResponseDto {
    private UUID id;
    private String title;
    private int price;
    private String content;
    private Course course;

    public CourseResponseDto(UUID id, String title, int price, String content, Course course) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.content = content;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
