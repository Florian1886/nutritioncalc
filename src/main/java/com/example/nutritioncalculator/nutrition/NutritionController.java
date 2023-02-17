package com.example.nutritioncalculator.nutrition;

import com.example.nutritioncalculator.dailyintake.DailyIntake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NutritionController {

    private final NutritionService nutritionService;


    @PostMapping("/addToDailyIntake")
    public String saveFoodIntoDailyIntake(String nameFood, Double weight, Model model){
        DailyIntake dailyIntake = nutritionService.saveNutritionToDailyIntake(nameFood, weight);
        model.addAttribute("dailyIntake", dailyIntake);
        return "resultFood";
    }


}
