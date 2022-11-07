package pl.project.charity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "{email.valid}")
    @Size(max = 60, message = "{email.max}")
    @NotEmpty(message = "{email.notEmpty}")
    @Column(length = 60, unique = true)
    private String email;

    @Size(min = 3, max = 60, message = "{firstName.min.max}")
    @NotEmpty(message = "{firstName.notEmpty}")
    @Column(length = 60)
    private String firstName;

    @Size(min = 3, max = 60, message = "{lastName.min.max}")
    @NotEmpty(message = "{lastName.notEmpty}")
    @Column(length = 60)
    private String lastName;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,100}$", message = "{weak.password}")
    @NotEmpty(message = "{password.notEmpty}")
    @Column(length = 100)
    private String password;

    @Column
    private boolean enabled;

    @Column
    private boolean access;

    @OneToOne
    private Authority authority;

    @Transient
    private String matchingPassword;

    @Transient
    private ChangeToken changeToken;


}