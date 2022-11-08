package pl.project.charity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "verification_tokens")
public class VerificationToken {
    @Id
    @Column(length = 60)
    private String token;

    @Column(length = 60)
    private String email;
}
