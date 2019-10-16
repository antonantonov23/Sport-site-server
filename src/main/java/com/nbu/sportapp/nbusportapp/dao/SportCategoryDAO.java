package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.business.SportCategory;
import com.nbu.sportapp.nbusportapp.repository.SportCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class SportCategoryDAO {


    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    /*to save an sportCategory in DB*/

    public SportCategory save(SportCategory sportCategory) {
        return this.sportCategoryRepository.save(sportCategory);
    }

    /*search all sportCategorys*/

    public List<SportCategory> findAll() {
        return this.sportCategoryRepository.findAll();
    }

    /*get an sportCategory*/

    public SportCategory findOne(Long sportCategoryId) {
        return this.sportCategoryRepository.findOne(sportCategoryId);
    }

    /*delete an sportCategory*/

    public void delete(SportCategory sportCategory) {
        this.sportCategoryRepository.delete(sportCategory);
    }
}
