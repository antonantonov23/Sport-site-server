package com.nbu.sportapp.nbusportapp.entity.event;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.nbu.sportapp.nbusportapp.entity.business.Team;

@Entity
@Table(name = "base_events")
@EntityListeners(AuditingEntityListener.class)
public class BaseEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@NotNull(message = "Start time cannot be empty")
	@Column
	private LocalDateTime startTime;

	// we will create one transient field for teamId
	@Column(name = "first_team_id")
	private Long firstTeamId;

	@Column(name = "second_team_id")
	private Long secondTeamId;

	@ManyToOne
	@JoinColumn(name = "first_team_id", insertable = false, updatable = false)
	private Team firstTeam;

	@ManyToOne
	@JoinColumn(name = "second_team_id", insertable = false, updatable = false)
	private Team secondTeam;

	@OneToMany(targetEntity = Comment.class, mappedBy = "baseEvent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference(value = "baseEvent-movement")
	private Set<Comment> comments = new HashSet<>();

	public BaseEvent() {
	}

	public BaseEvent(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Long getFirstTeamId() {
		return firstTeamId;
	}

	public void setFirstTeamId(Long firstTeamId) {
		this.firstTeamId = firstTeamId;
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(Team firstTeam) {
		this.firstTeam = firstTeam;
	}

	public Long getSecondTeamId() {
		return secondTeamId;
	}

	public void setSecondTeamId(Long secondTeamId) {
		this.secondTeamId = secondTeamId;
	}

	public Team getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(Team secondTeam) {
		this.secondTeam = secondTeam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}