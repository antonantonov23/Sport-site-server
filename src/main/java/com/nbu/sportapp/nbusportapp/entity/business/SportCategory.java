package com.nbu.sportapp.nbusportapp.entity.business;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sport_categories")
@EntityListeners(AuditingEntityListener.class)
public class SportCategory extends AbstractPersistable<Long> {

    private Long id;
    @NotBlank
    private String nameOfCategory;


    // sportCategory promenlivata ot league
    @OneToMany(targetEntity = League.class, mappedBy = "sportCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<League> leagues = new HashSet<>();


    public SportCategory(){}
    public SportCategory(String nameOfCategory){
        this.nameOfCategory = nameOfCategory;
    }
    public SportCategory(String nameOfCategory, Set<League> leagues) {
        this.nameOfCategory = nameOfCategory;
        this.leagues = leagues;
    }

    public Set<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
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
