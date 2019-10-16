package com.nbu.sportapp.nbusportapp.entity.business;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leagues")
@EntityListeners(AuditingEntityListener.class)
public class League extends AbstractPersistable<Long> {

    private Long id;
    @NotBlank
    private String nameOfLeague;

    // league promenlivata ot team
    @OneToMany(targetEntity = Team.class, mappedBy = "league", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Team> teams = new HashSet<>();

    @Column(name="sport_category_id",insertable=false, updatable=false)
    private Long sportCategoryId;

    @ManyToOne
 //   @JoinColumn(name = "sport_category_id")
    @JsonBackReference
    private SportCategory sportCategory;


    public League(String nameOfLeague, Set<Team> teams) {
        this.nameOfLeague = nameOfLeague;
        this.teams = teams;
    }

    public League() {
    }


    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public String getNameOfLeague() {
        return nameOfLeague;
    }

    public void setNameOfLeague(String nameOfLeague) {
        this.nameOfLeague = nameOfLeague;
    }

    public Long getSportCategoryId() {
        return sportCategoryId;
    }

    public void setSportCategoryId(Long sportCategoryId) {
        this.sportCategoryId = sportCategoryId;
    }

    public SportCategory getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(SportCategory sportCategory) {
        this.sportCategory = sportCategory;
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
