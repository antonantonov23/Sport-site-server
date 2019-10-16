package com.nbu.sportapp.nbusportapp.entity.business;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "players")
@EntityListeners(AuditingEntityListener.class)
public class Player extends AbstractPersistable<Long> {

    private Long id;

    @NotBlank
    private String nameOfPlayer;

    @NotBlank
    private String dateOfBirth;

    @Column
    private Integer number;

    // we will create one transient field for teamId
    @Column(name="team_id", insertable=false, updatable=false)
    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "team")
    @JsonBackReference
    private Team team;

    public Player() {
    }

    public Player(String nameOfPlayer, String dateOfBirth) {
        this.nameOfPlayer = nameOfPlayer;
        this.dateOfBirth = dateOfBirth;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}