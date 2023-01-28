package com.example.nutritioncalculator.food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findByName(String name);
}
