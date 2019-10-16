package com.nbu.sportapp.nbusportapp.repository;

import com.nbu.sportapp.nbusportapp.entity.business.SportCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SportCategoryRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    @Test
    public void testSaveSportCategory(){
        SportCategory sportCategory = new SportCategory("Cricket");
        SportCategory saveInDb = this.entityManager.persist(sportCategory);
        SportCategory getFromDb = this.sportCategoryRepository.findOne(saveInDb.getId());

        assertThat(getFromDb).isEqualTo(saveInDb);
    }

    @Test
    public void testGetSportCategoryById(){
        SportCategory sportCategory = new SportCategory("Cricket");

        //Save sportCategory in DB
        SportCategory sportCategorySavedInDb = entityManager.persist(sportCategory);

        //Get sportCategory from DB
        SportCategory sportCategoryFromInDb = this.sportCategoryRepository.findOne(sportCategorySavedInDb.getId());
        assertThat(sportCategorySavedInDb).isEqualTo(sportCategoryFromInDb);
    }

    @Test
    public void testGetAllSportCategorys(){
        SportCategory sportCategory1 = new SportCategory("Cricket");


        SportCategory sportCategory2 = new SportCategory("Football");


        //Save both sportCategories in DB
        entityManager.persist(sportCategory1);
        entityManager.persist(sportCategory2);

        Iterable<SportCategory> allSportCategoriesFromDb = this.sportCategoryRepository.findAll();
        List<SportCategory> sportCategoryList = new ArrayList<>();

        for (SportCategory sportCategory: allSportCategoriesFromDb) {
            sportCategoryList.add(sportCategory);
        }
        assertThat(sportCategoryList.size()).isEqualTo(2);
    }


    @Test
    public void testFindByName(){
        SportCategory sportCategory = new SportCategory("Cricket");


        //SportCategory in DB
        entityManager.persist(sportCategory);

        //Get ticket info from DB for specified email
        SportCategory getFromDb = this.sportCategoryRepository.findByNameOfCategory("Cricket");
        assertThat(getFromDb.getNameOfCategory()).isEqualTo("Cricket");
    }

    @Test
    public void testDeleteSportCategoryById(){
        SportCategory sportCategory1 = new SportCategory("Cricket");


        SportCategory sportCategory2 = new SportCategory("Football");

        //Save both sportCategories in DB
        SportCategory persist = entityManager.persist(sportCategory1);
        entityManager.persist(sportCategory2);

        //delete one sportCategory DB
        entityManager.remove(persist);

        Iterable<SportCategory> allSportCategoriesFromDb = this.sportCategoryRepository.findAll();
        List<SportCategory> sportCategoryList = new ArrayList<>();

        for (SportCategory sportCategory: allSportCategoriesFromDb) {
            sportCategoryList.add(sportCategory);
        }
        assertThat(sportCategoryList.size()).isEqualTo(1);
    }

    @Test
    public void testUpdateSportCategory(){
        SportCategory sportCategory = new SportCategory("Cricket");



        //save SportCategory info in DB
        entityManager.persist(sportCategory);

        SportCategory getFromDb = this.sportCategoryRepository.findByNameOfCategory("Cricket");
        //update Email Address
        getFromDb.setNameOfCategory("Football");
        entityManager.persist(getFromDb);

        assertThat(getFromDb.getNameOfCategory()).isEqualTo("Football");
    }
}
