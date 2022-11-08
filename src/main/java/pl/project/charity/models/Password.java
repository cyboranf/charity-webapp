package pl.project.charity.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class Password {
    private String email;

    private String password;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,100}$", message = "{weak.password}")
    @NotEmpty(message = "{newPassword.notEmpty}")
    private String newPassword;

    private String matchingNewPassword;

    private String token;
}
