package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.LeagueDAO;
import com.nbu.sportapp.nbusportapp.dao.TeamDAO;
import com.nbu.sportapp.nbusportapp.entity.business.Player;
import com.nbu.sportapp.nbusportapp.entity.business.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/sportapp")
public class TeamController {

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    LeagueDAO leagueDAO;

    public TeamController() {
    }

    /* to save an team*/
    @PostMapping("/team")
    public Team createTeam(@Valid @RequestBody Team team) {
        Team newTeam = new Team();
        newTeam.setLeagueId(team.getLeagueId());
        newTeam.setLeagueName(this.leagueDAO.findOne(team.getLeagueId()).getNameOfLeague());
        newTeam.setNameOfTeam(team.getNameOfTeam());

        return this.teamDAO.save(newTeam);
    }

    /*get all teams*/
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return this.teamDAO.findAll();
    }

    /*get an team by ID*/
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId) {
        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(team);
    }

    /*get players by team ID*/
    @GetMapping("/playersByTeam/{id}")
    public ResponseEntity<Set<Player>> getPlayersByTeamId(@PathVariable(value = "id") Long teamId) {
        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(team.getPlayers());
    }

    /*update an team*/
    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") Long teamId, @Valid @RequestBody Team teamDetails) {
        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        // remove setLeague if doesnt work
        team.setNameOfTeam(teamDetails.getNameOfTeam());
        team.setLeagueId(teamDetails.getLeagueId());
        Team updateTeam = this.teamDAO.save(team);
        return ResponseEntity.ok().body(updateTeam);

    }

    /*delete an team*/
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable(value = "id") Long teamId) {

        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        this.teamDAO.delete(team);

        return ResponseEntity.ok().build();
    }

}
