package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name ="courses")

public class Course {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String title;
    private int price;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_course_user",
                    foreignKeyDefinition = "FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE"))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_course_company",
                    foreignKeyDefinition = "FOREIGN KEY (companies_id) REFERENCES companies(id) ON DELETE CASCADE"))
    private Company company;

    public Course() {
    }

    public Course(String title, int price, String content, User user, Company company) {
        this.title = title;
        this.price = price;
        this.content = content;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
