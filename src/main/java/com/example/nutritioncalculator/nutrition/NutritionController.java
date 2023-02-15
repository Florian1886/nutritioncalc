package com.example.nutritioncalculator.nutrition;

import com.example.nutritioncalculator.dailyintake.DailyIntake;
import com.example.nutritioncalculator.food.Food;
import com.example.nutritioncalculator.food.dto.FoodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NutritionController {

    private final NutritionService nutritionService;

//TODO weight is fine, nameFood doesnt transfer :(
    @PostMapping("/addToDailyIntake")
    public String saveFoodIntoDailyIntake(String nameFood, Double weight, Model model){
        model.addAttribute("name", nameFood);
        model.addAttribute("weight", weight);
        return "/resultFood";
    }

    @PostMapping("/addFoodList")
    public DailyIntake addNutrition(@RequestBody List<Food> foods){
        return nutritionService.saveNutritionIntoDailyIntake(foods);
    }
}
