package com.nbu.sportapp.nbusportapp.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.nbu.sportapp.nbusportapp.mail.scheduler.MailJobFactory;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbu.sportapp.nbusportapp.dao.AccountDAO;
import com.nbu.sportapp.nbusportapp.dao.BaseEventDAO;
import com.nbu.sportapp.nbusportapp.dao.TeamDAO;
import com.nbu.sportapp.nbusportapp.entity.account.Account;
import com.nbu.sportapp.nbusportapp.entity.business.Team;
import com.nbu.sportapp.nbusportapp.entity.event.BaseEvent;

@RestController
@RequestMapping("/sportapp")
public class BaseEventController {

	@Autowired
	BaseEventDAO baseEventDAO;

	@Autowired
	AccountDAO accountDAO;

	@Autowired
	TeamDAO teamDAO;

	/* to save an baseEvent */
	@PostMapping("/baseEvent")
	public BaseEvent createBaseEvent(@RequestBody BaseEvent baseEvent) {
		Team firstTeam = this.teamDAO.findOne(baseEvent.getFirstTeamId());
		Team secondTeam = this.teamDAO.findOne(baseEvent.getSecondTeamId());
		BaseEvent currentEvent = new BaseEvent();
		currentEvent.setStartTime(baseEvent.getStartTime());
		currentEvent.setFirstTeam(firstTeam);
		currentEvent.setFirstTeamId(baseEvent.getFirstTeamId());
		currentEvent.setSecondTeam(secondTeam);
		currentEvent.setSecondTeamId(baseEvent.getSecondTeamId());
		System.out.println(baseEvent.getFirstTeamId());
		System.out.println(baseEvent.getSecondTeamId());
		return this.baseEventDAO.save(currentEvent);
	}

	/* get all baseEvents */
	@GetMapping("/baseEvents")
	public List<BaseEvent> getAllBaseEvents() {
		return this.baseEventDAO.findAll();
	}

	/* get a baseEvent by ID */
	@GetMapping("/baseEvents/{id}")
	public ResponseEntity<BaseEvent> getBaseEventById(@PathVariable(value = "id") Long baseEventId) {
		BaseEvent baseEvent = this.baseEventDAO.findOne(baseEventId);
		if (baseEvent == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(baseEvent);
	}

	/* update a baseEvent */
	@PutMapping("/baseEvents/{id}")
	public ResponseEntity<BaseEvent> updateBaseEvent(@PathVariable(value = "id") Long baseEventId,
			@Valid @RequestBody BaseEvent baseEventDetails) {
		BaseEvent baseEvent = this.baseEventDAO.findOne(baseEventId);
		if (baseEvent == null) {
			return ResponseEntity.notFound().build();
		}

		baseEvent.setStartTime(baseEventDetails.getStartTime());
		baseEvent.setFirstTeamId(baseEventDetails.getFirstTeamId());
		baseEvent.setSecondTeamId(baseEventDetails.getSecondTeamId());
		baseEvent.setFirstTeam(baseEventDetails.getFirstTeam());
		baseEvent.setSecondTeam(baseEventDetails.getSecondTeam());
		

		BaseEvent updateBaseEvent = this.baseEventDAO.save(baseEvent);
		return ResponseEntity.ok().body(updateBaseEvent);

	}

	/* delete a baseEvent */
	@DeleteMapping("/baseEvents/{id}")
	public ResponseEntity<BaseEvent> deleteBaseEvent(@PathVariable(value = "id") Long baseEventId) {

		BaseEvent baseEvent = this.baseEventDAO.findOne(baseEventId);
		if (baseEvent == null) {
			return ResponseEntity.notFound().build();
		}
		this.baseEventDAO.delete(baseEvent);

		return ResponseEntity.ok().build();
	}

	/* subscription to a baseEvent */
	@PostMapping("/baseEvents/subscribe/{subscriberId}/{eventId}")
	public ResponseEntity<BaseEvent> subscribeToAnEvent(@PathVariable(value = "subscriberId") Long subscriberId,
			@PathVariable(value = "eventId") Long baseEventId) {
		MailJobFactory mailFactory = new MailJobFactory();
		try {
			mailFactory.createAndScheduleMailJob(getEvent(baseEventId), getAccount(subscriberId));

			return ResponseEntity.ok().build();
		} catch (SchedulerException e) {
			return ResponseEntity.badRequest().build();
		} catch (ParseException e) {
			return ResponseEntity.status(500).build();
		}
	}

	private BaseEvent getEvent(Long id) {
		System.out.println(id);
		return this.baseEventDAO.findOne(id);
	}

	private Account getAccount(Long id) {
		return this.accountDAO.findOne(id);
	}

}
