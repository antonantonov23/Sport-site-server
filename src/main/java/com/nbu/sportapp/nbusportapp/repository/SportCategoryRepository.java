package com.nbu.sportapp.nbusportapp.repository;

import com.nbu.sportapp.nbusportapp.entity.business.SportCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportCategoryRepository extends JpaRepository<SportCategory, Long> {
    SportCategory findByNameOfCategory(String nameOfCategory);

}
