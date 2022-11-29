package pl.project.charity.service;

import pl.project.charity.models.Password;

public interface PasswordService {

    void createResetToken(Password password, String token);

    void update(Password password);
}