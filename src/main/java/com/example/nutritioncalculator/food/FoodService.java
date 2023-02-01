package com.example.nutritioncalculator.food;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> saveFoods(List<Food> foods) {
        return foodRepository.saveAll(foods);
    }

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(int id) {
        return foodRepository.findById(id).orElse(null);
    }

    public Food getFoodByName(String name) {
        return foodRepository.findByName(name);
    }

    public String deleteFood(int id) {
        foodRepository.deleteById(id);
        return "food removed " + id;
    }

    public Food updateFood(Food food) {
        Food existingFood = foodRepository.findById(food.getIdF()).orElse(null);
        existingFood.setName(food.getName());
        existingFood.setCalories(food.getCalories());
        return foodRepository.save(existingFood);
    }
}
