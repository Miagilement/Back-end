package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ConfirmationTokenDao;
import com.projectagile.webprojectagile.entity.ConfirmationToken;
import com.projectagile.webprojectagile.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmailServiceImpl implements EmailService {

    private ConfirmationTokenDao confirmationTokenDao;

    private JavaMailSender javaMailSender;

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    @Override
    public void saveToken(ConfirmationToken confirmationToken) {
        this.confirmationTokenDao.save(confirmationToken);
    }

    @Override
    public ConfirmationToken findToken(String confirmationToken) {
        return confirmationTokenDao.findByConfirmationToken(confirmationToken);
    }

}
