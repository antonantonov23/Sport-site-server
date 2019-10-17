package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.LeagueDAO;
import com.nbu.sportapp.nbusportapp.entity.business.League;
import com.nbu.sportapp.nbusportapp.entity.business.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/sportapp")
public class LeagueController {

    @Autowired
    LeagueDAO leagueDAO;

    /* to save an league*/
    @PostMapping("/league")
    public League createLeague(@Valid @RequestBody League league) {
        return this.leagueDAO.save(league);
    }

    /*get all leagues*/
    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return this.leagueDAO.findAll();
    }

    /*get an league by ID*/
    @GetMapping("/leagues/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable(value = "id") Long leagueId) {
        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(league);
    }

    /*get teams by league ID*/
    @GetMapping("/teamsByLeague/{id}")
    public ResponseEntity<Set<Team>> getPlayersByTeamId(@PathVariable(value = "id") Long leagueId) {
        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(league.getTeams());
    }

    /*update an league*/
    @PutMapping("/leagues/{id}")
    public ResponseEntity<League> updateLeague(@PathVariable(value = "id") Long leagueId, @Valid @RequestBody League leagueDetails) {
        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }
        // remove setsportcategory if doesnt work
        league.setNameOfLeague(leagueDetails.getNameOfLeague());
        league.setSportCategory(leagueDetails.getSportCategory());
        League updateLeague = this.leagueDAO.save(league);
        return ResponseEntity.ok().body(updateLeague);

    }

    /*delete an league*/
    @DeleteMapping("/leagues/{id}")
    public ResponseEntity<League> deleteLeague(@PathVariable(value = "id") Long leagueId) {

        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }
        this.leagueDAO.delete(league);

        return ResponseEntity.ok().build();
    }

}