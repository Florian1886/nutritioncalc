package com.example.nutritioncalculator.dailyintake;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyIntakeService {

    DailyIntakeRepository dailyIntakeRepository;

    //TO DO
    public DailyIntake addFoodToDaily(DailyIntake dailyIntake){

        return dailyIntakeRepository.save(dailyIntake);
    }
}
