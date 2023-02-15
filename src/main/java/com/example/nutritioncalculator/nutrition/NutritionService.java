package com.example.nutritioncalculator.nutrition;


import com.example.nutritioncalculator.dailyintake.DailyIntake;
import com.example.nutritioncalculator.dailyintake.DailyIntakeRepository;
import com.example.nutritioncalculator.food.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NutritionService {


    private final DailyIntakeRepository dailyIntakeRepository;

    public DailyIntake saveNutritionIntoDailyIntake(List<Food> foods){
        LocalDate date = LocalDate.now();
        DailyIntake dailyIntake = dailyIntakeRepository.findByDate(date).stream().findFirst().orElse(null);

        if(dailyIntake == null){
            dailyIntake = generateNewDailyIntake(date);
        }
        return dailyIntakeRepository.save(updateDailyIntake(foods, dailyIntake));
    }

    private DailyIntake generateNewDailyIntake(LocalDate date) {
        return new DailyIntake(date, 0, 0 ,0 ,0);
    }
    private DailyIntake updateDailyIntake(List<Food> foods, DailyIntake dailyIntake) {
        for(Food food : foods){
            dailyIntake.setCalories(dailyIntake.getCalories() + food.getCalories());
            dailyIntake.setProtein(dailyIntake.getProtein() + food.getProtein());
            dailyIntake.setFat(dailyIntake.getFat() + food.getFat());
            dailyIntake.setCarbohydrates(dailyIntake.getCarbohydrates() + food.getCarbohydrates());
        }
        return dailyIntake;
    }

}
