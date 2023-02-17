package com.example.nutritioncalculator.nutrition;


import com.example.nutritioncalculator.dailyintake.DailyIntake;
import com.example.nutritioncalculator.dailyintake.DailyIntakeRepository;
import com.example.nutritioncalculator.food.Food;
import com.example.nutritioncalculator.food.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NutritionService {

    private final FoodRepository foodRepository;
    private final DailyIntakeRepository dailyIntakeRepository;

    public DailyIntake saveNutritionToDailyIntake(String nameFood, Double weight){

        Food foodAdd = foodRepository.findByName(nameFood);

        if (isFoodAndWeightValid(weight, foodAdd)) return null;

        DailyIntake dailyIntake = findTodayDailyIntake();

        if(dailyIntake == null){
            dailyIntake = generateNewDailyIntake();
        }

        return dailyIntakeRepository.save(updateDailyIntake(foodAdd, dailyIntake, weight));
    }

    private boolean isFoodAndWeightValid(Double weight, Food foodAdd) {
        return foodAdd == null || weight == null;
    }

    private DailyIntake findTodayDailyIntake(){
        return dailyIntakeRepository.findByDate(LocalDate.now()).stream().findFirst().orElse(null);
    }
    private DailyIntake generateNewDailyIntake() {
        return new DailyIntake(LocalDate.now(), 0, 0 ,0 ,0);
    }
    private DailyIntake updateDailyIntake(Food food, DailyIntake dailyIntake, Double weight) {
        dailyIntake.setCalories(dailyIntake.getCalories() + food.getCalories() * weight / 100);
        dailyIntake.setProtein(dailyIntake.getProtein() + food.getProtein() * weight / 100);
        dailyIntake.setFat(dailyIntake.getFat() + food.getFat() * weight / 100);
        dailyIntake.setCarbohydrates(dailyIntake.getCarbohydrates() + food.getCarbohydrates() * weight / 100);
        return dailyIntake;
    }

}
