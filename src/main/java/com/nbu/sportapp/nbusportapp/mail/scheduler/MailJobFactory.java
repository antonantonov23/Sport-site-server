package com.nbu.sportapp.nbusportapp.mail.scheduler;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import com.nbu.sportapp.nbusportapp.entity.account.Account;
import com.nbu.sportapp.nbusportapp.entity.event.BaseEvent;
import com.nbu.sportapp.nbusportapp.mail.job.MailJob;

@Component
public class MailJobFactory {

	public void createAndScheduleMailJob(BaseEvent event, Account account)
			throws SchedulerException, ParseException {
		// TODO make base event sport event
		JobDetail job = JobBuilder.newJob(MailJob.class).usingJobData("firstTeam", event.getFirstTeam().getNameOfTeam())
				.usingJobData("secondTeam", event.getSecondTeam().getNameOfTeam())
				.usingJobData("subscriberName", account.getFullName())
				.usingJobData("subscriberEmail", account.getEmail()).build();

		LocalDateTime startTime = event.getStartTime();

		LocalDateTime triggerTime = createTriggerTime(startTime);

		Date date = Date.from(triggerTime.atZone(ZoneId.systemDefault()).toInstant());
		Trigger trigger = TriggerBuilder.newTrigger().startAt(date).build();
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			throw e;
		}
	}

	private LocalDateTime createTriggerTime(LocalDateTime startTime) {
		LocalDate triggerDate = LocalDate.of(startTime.getYear(), startTime.getMonth(), startTime.getDayOfMonth());

		LocalDateTime triggerDateTime;
		if(startTime.getHour() == 0){
			triggerDateTime = triggerDate.atTime(23, startTime.getMinute(),
					startTime.getSecond());
		}
		else {
			triggerDateTime = triggerDate.atTime(startTime.getHour() - 1, startTime.getMinute(),
					startTime.getSecond());
		}
		return triggerDateTime;
	}

}
