package com.example.nutritioncalculator.dailyintake;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DailyIntakeService {

    DailyIntakeRepository dailyIntakeRepository;

    public List<DailyIntake> getAllDailyIntake(){
        return dailyIntakeRepository.findAll();
    }
}
