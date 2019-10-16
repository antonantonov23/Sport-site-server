package com.nbu.sportapp.nbusportapp.mail.service.impl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.nbu.sportapp.nbusportapp.mail.service.IEmailService;

public class EmailService implements IEmailService {

    private JavaMailSender javaMailSender;


    public EmailService(JavaMailSenderImpl sender) {

        Properties mailProperties = new Properties();

        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttls.enable", true);
        sender.setJavaMailProperties(mailProperties);
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("sportappnbu@gmail.com");
        sender.setPassword("!nbu123456");
        this.javaMailSender = sender;
    }

    @Override
    public void sendEmail(String firstTeam, String secondTeam, String subscriberName, String subscriberEmail) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(subscriberEmail);
        message.setFrom("sportappnbu@gmail.com");
        message.setSubject("The event you have subscribed for starts in an hour.");
        message.setText(
                "Hey, " + subscriberName + "\n" + "Your event: " + firstTeam + "-" + secondTeam + " will start in 1 hour. Make sure not to miss it!");
        this.javaMailSender.send(message);
    }

}
