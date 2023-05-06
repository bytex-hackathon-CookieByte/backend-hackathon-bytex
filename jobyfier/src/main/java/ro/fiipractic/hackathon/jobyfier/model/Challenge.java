package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "challenges")

public class Challenge {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String title;

    private String description;

    private int price;

    private int adPrice;

    private long startTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_challenge_company",
                    foreignKeyDefinition = "FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE"))
    private Company company;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Stage> stages;

    public Challenge() {
    }

    public Challenge(String title, String description, int price, int adPrice, long startTime, Company company, List<Stage> stages) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.adPrice = adPrice;
        this.startTime = startTime;
        this.company = company;
        this.stages = stages;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(int adPrice) {
        this.adPrice = adPrice;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public List<Stage> getStages() {
        return stages;
    }

}
