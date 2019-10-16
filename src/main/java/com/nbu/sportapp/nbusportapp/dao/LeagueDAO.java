package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.business.League;
import com.nbu.sportapp.nbusportapp.repository.LeagueRepository;
import com.nbu.sportapp.nbusportapp.repository.SportCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class LeagueDAO {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    /*to save an account in DB*/

    public League save(League league) {
        league.setSportCategory(this.sportCategoryRepository.findOne(league.getSportCategoryId()));
        return this.leagueRepository.save(league);
    }

    /*search all users*/

    public List<League> findAll() {
        return this.leagueRepository.findAll();
    }

    /*get an account*/

    public League findOne(Long userId) {
        return this.leagueRepository.findOne(userId);
    }

    /*delete an account*/

    public void delete(League league) {
        this.leagueRepository.delete(league);
    }
}
