package com.clothingshop.repository;

import com.clothingshop.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//defines the repository for the ClothingItem entity. 
//The repository is responsible for performing CRUD operations on the ClothingItem entity
public interface ClothingRepository extends JpaRepository<ClothingItem, Long> {
}