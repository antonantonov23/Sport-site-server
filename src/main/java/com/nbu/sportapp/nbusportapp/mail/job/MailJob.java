package com.nbu.sportapp.nbusportapp.mail.job;

import java.time.LocalDateTime;

import com.nbu.sportapp.nbusportapp.mail.service.IEmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.nbu.sportapp.nbusportapp.mail.service.impl.EmailService;

@Component
public class MailJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String firstTeam = context.getJobDetail().getJobDataMap().getString("firstTeam");
		String secondTeam = context.getJobDetail().getJobDataMap().getString("secondTeam");
		String subscriberName = context.getJobDetail().getJobDataMap().getString("subscriberName");
		String subscriberEmail = context.getJobDetail().getJobDataMap().getString("subscriberEmail");
		sendEmail(firstTeam, secondTeam, subscriberName, subscriberEmail);
	}

	public void sendEmail(String firstTeam, String secondTeam, String subscriberName, String subscriberEmail) {
		IEmailService emailService = new EmailService(new JavaMailSenderImpl());
		emailService.sendEmail(firstTeam, secondTeam, subscriberName, subscriberEmail);
		System.out.println("job triggered at: " + LocalDateTime.now());
	}
}
