package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.business.Player;
import com.nbu.sportapp.nbusportapp.repository.PlayerRepository;
import com.nbu.sportapp.nbusportapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class PlayerDAO {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    /*to save a player in DB*/

    public Player save(Player player) {
        player.setTeam(this.teamRepository.findOne(player.getTeamId()));
        return this.playerRepository.save(player);
    }

    /*search all players*/

    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    /*get an player*/

    public Player findOne(Long playerId) {
        return this.playerRepository.findOne(playerId);
    }

    /*delete an player*/

    public void delete(Player player) {
        this.playerRepository.delete(player);
    }

}
