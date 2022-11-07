package pl.project.charity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "change_tokens")
public class ChangeToken {
    @Id
    @Column(length = 60)
    private String token;

    @Column(length = 60)
    private String email;

    @Email(message = "{email.valid}")
    @Size(max = 60, message = "{email.max}")
    @NotEmpty(message = "{email.notEmpty}")
    @Column(length = 60)
    private String newEmail;
}
