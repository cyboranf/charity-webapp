package pl.project.charity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "reset_tokens")
public class ResetToken {
    @Id
    @Column(length = 60)
    private String token;

    @Column(length = 60)
    private String email;
}
