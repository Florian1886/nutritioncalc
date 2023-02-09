package com.example.nutritioncalculator.nutrition;


import com.example.nutritioncalculator.dailyintake.DailyIntake;
import com.example.nutritioncalculator.dailyintake.DailyIntakeRepository;
import com.example.nutritioncalculator.food.Food;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class NutritionService {


    private DailyIntakeRepository dailyIntakeRepository;

    public DailyIntake saveNutritionIntoDailyIntake(List<Food> foods){
        DailyIntake dailyIntakeHelper = new DailyIntake();
        LocalDate date = LocalDate.now();
        DailyIntake dailyIntake = dailyIntakeRepository.findByDate(date).stream().findFirst().orElse(null);

        if(dailyIntake == null){
            dailyIntakeHelper.setDate(date);
            dailyIntakeHelper.setCalories(0);
            dailyIntakeHelper.setCarbohydrates(0);
            dailyIntakeHelper.setFat(0);
            dailyIntakeHelper.setProtein(0);
            dailyIntake = dailyIntakeHelper;
        }

        for(Food food : foods){
            dailyIntake.setCalories(dailyIntake.getCalories() + food.getCalories());
            dailyIntake.setProtein(dailyIntake.getProtein() + food.getProtein());
            dailyIntake.setFat(dailyIntake.getFat() + food.getFat());
            dailyIntake.setCarbohydrates(dailyIntake.getCarbohydrates() + food.getCarbohydrates());
        }

        return dailyIntakeRepository.save(dailyIntake);
    }
}
