package com.example.nutritioncalculator.dailyintake;

import com.example.nutritioncalculator.food.Food;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class DailyIntake {
    @Id
    @GeneratedValue
    private int idDI;
    private LocalDate date;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;
}
