package com.example.nutritioncalculator.dailyintake.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
public class DailyIntakeDto {
    private LocalDate date;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;
}
