package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.ConfirmationToken;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage email);

    void saveToken(ConfirmationToken confirmationToken);

    ConfirmationToken findToken(String confirmationToken);
}
