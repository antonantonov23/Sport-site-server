package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.SportCategoryDAO;
import com.nbu.sportapp.nbusportapp.entity.business.League;
import com.nbu.sportapp.nbusportapp.entity.business.SportCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sportapp")
public class SportCategoryController {

    @Autowired
    SportCategoryDAO sportCategoryDAO;

    public SportCategoryController() {
    }

    /* to save an sportCategory*/
    @PostMapping("/sportCategory")
    public SportCategory createSportCategory(@Valid @RequestBody SportCategory sportCategory) {
        return this.sportCategoryDAO.save(sportCategory);
    }

    /*get all sportCategories*/
    @GetMapping("/sportCategories")
    public List<SportCategory> getAllSportCategories() {
        return this.sportCategoryDAO.findAll();
    }

    /*get an sportCategory by ID*/
    @GetMapping("/sportCategories/{id}")
    public ResponseEntity<SportCategory> getSportCategoryById(@PathVariable(value = "id") Long sportCategoryId) {
        SportCategory sportCategory = this.sportCategoryDAO.findOne(sportCategoryId);
        if (sportCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sportCategory);
    }

    /*get leagues by sportCategory ID*/
    @GetMapping("/leaguesBySportCategory/{id}")
    public ResponseEntity<Set<League>> getLeaguesBySportCategoryId(@PathVariable(value = "id") Long sportCategoryId) {
        SportCategory sportCategory = this.sportCategoryDAO.findOne(sportCategoryId);
        if (sportCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sportCategory.getLeagues());
    }

    /*update an sportCategory*/
    @PutMapping("/sportCategories/{id}")
    public ResponseEntity<SportCategory> updateSportCategory(@PathVariable(value = "id") Long sportCategoryId, @Valid @RequestBody SportCategory sportCategoryDetails) {
        SportCategory sportCategory = this.sportCategoryDAO.findOne(sportCategoryId);
        if (sportCategory == null) {
            return ResponseEntity.notFound().build();
        }
        // remove bla bla
        sportCategory.setNameOfCategory(sportCategoryDetails.getNameOfCategory());
        sportCategory.setLeagues(sportCategoryDetails.getLeagues());
        SportCategory updateSportCategory = this.sportCategoryDAO.save(sportCategory);
        return ResponseEntity.ok().body(updateSportCategory);

    }

    /*delete an sportCategory*/
    @DeleteMapping("/sportCategories/{id}")
    public ResponseEntity<SportCategory> deleteSportCategory(@PathVariable(value = "id") Long sportCategoryId) {

        SportCategory sportCategory = this.sportCategoryDAO.findOne(sportCategoryId);
        if (sportCategory == null) {
            return ResponseEntity.notFound().build();
        }
        this.sportCategoryDAO.delete(sportCategory);

        return ResponseEntity.ok().build();
    }

}