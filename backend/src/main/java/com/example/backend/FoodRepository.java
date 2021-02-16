package com.example.backend;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
