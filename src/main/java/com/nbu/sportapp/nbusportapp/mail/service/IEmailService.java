package com.nbu.sportapp.nbusportapp.mail.service;

import org.springframework.stereotype.Component;

@Component
public interface IEmailService {
	void sendEmail(String firstTeam, String secondTeam, String subscriberName, String subscriberEmail);
}
