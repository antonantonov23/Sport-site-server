package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.PlayerDAO;
import com.nbu.sportapp.nbusportapp.entity.business.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/sportapp")
public class PlayerController {

    @Autowired
    PlayerDAO playerDAO;

    public PlayerController() {
    }

    /* to save an player*/
    @PostMapping("/player")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return this.playerDAO.save(player);
    }

    /*get all players*/
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return this.playerDAO.findAll();
    }

    /*get an player by ID*/
    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = "id") Long playerId) {
        Player player = this.playerDAO.findOne(playerId);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(player);
    }

    /*update an player*/
    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable(value = "id") Long playerId, @Valid @RequestBody Player playerDetails) {
        Player player = this.playerDAO.findOne(playerId);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        player.setNameOfPlayer(playerDetails.getNameOfPlayer());
        player.setDateOfBirth(playerDetails.getDateOfBirth());
        Player updatePlayer = this.playerDAO.save(player);
        return ResponseEntity.ok().body(updatePlayer);

    }

    /*delete an player*/
    @DeleteMapping("/players/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable(value = "id") Long playerId) {

        Player player = this.playerDAO.findOne(playerId);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        this.playerDAO.delete(player);

        return ResponseEntity.ok().build();
    }

}
