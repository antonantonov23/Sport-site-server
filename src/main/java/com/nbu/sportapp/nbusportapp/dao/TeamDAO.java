package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.business.Team;
import com.nbu.sportapp.nbusportapp.repository.LeagueRepository;
import com.nbu.sportapp.nbusportapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class TeamDAO {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    /*to save an account in DB*/

    public Team save(Team team) {
        team.setLeague(this.leagueRepository.findOne(team.getLeagueId()));
        return this.teamRepository.save(team);
    }

    /*search all users*/

    public List<Team> findAll() {
        return this.teamRepository.findAll();
    }

    /*get an account*/

    public Team findOne(Long teamId) {
        return this.teamRepository.findOne(teamId);
    }

    /*delete an account*/

    public void delete(Team team) {
        this.teamRepository.delete(team);
    }

}
