package com.example.nutritioncalculator.dailyintake;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyIntakeService {

    private final DailyIntakeRepository dailyIntakeRepository;

    public List<DailyIntake> getAllDailyIntake(){
        return dailyIntakeRepository.findAll();
    }

    public DailyIntake getTodayDailyIntake(){
        return dailyIntakeRepository.findByDate(LocalDate.now()).orElse(null);
    }
}
