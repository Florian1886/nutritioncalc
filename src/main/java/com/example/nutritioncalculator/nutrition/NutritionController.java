package com.example.nutritioncalculator.nutrition;

import com.example.nutritioncalculator.dailyintake.DailyIntake;
import com.example.nutritioncalculator.dailyintake.DailyIntakeRepository;
import com.example.nutritioncalculator.food.Food;
import com.example.nutritioncalculator.food.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NutritionController {

    private final FoodRepository foodRepository;
    private final DailyIntakeRepository dailyIntakeRepository;

    private final NutritionService nutritionService;


    @PostMapping("/addFoodList")
    public DailyIntake addNutrition(@RequestBody List<Food> foods){
        return nutritionService.saveNutritionIntoDailyIntake(foods);
    }
}
