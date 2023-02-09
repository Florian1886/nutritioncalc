package com.example.nutritioncalculator.nutrition;

import com.example.nutritioncalculator.dailyintake.DailyIntake;
import com.example.nutritioncalculator.dailyintake.DailyIntakeRepository;
import com.example.nutritioncalculator.food.Food;
import com.example.nutritioncalculator.food.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NutritionController {

    private FoodRepository foodRepository;
    private DailyIntakeRepository dailyIntakeRepository;

    private NutritionService nutritionService;


    @PostMapping("/addFoodList")
    public DailyIntake addNutrition(@RequestBody List<Food> foods){
        return nutritionService.saveNutritionIntoDailyIntake(foods);
    }
}
