package ro.fiipractic.hackathon.jobyfier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Fixed extends Question{
    private String quiz1;
    private String quiz2;
    private String quiz3;
    private String quiz4;

}
