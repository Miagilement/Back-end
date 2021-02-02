/* Cette classe est requise pour envoyer le lien d'activation ou 
de confirmation à l'adresse e-mail de l'utilisateur une fois l'inscription terminée. 

Pour réaliser cette fonctionnalité, nous utilisons l'API Spring Mail.
*/
package com.projectagile.webprojectagile.service.impl;
import com.projectagile.webprojectagile.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

}
