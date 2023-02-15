package com.example.nutritioncalculator.dailyintake;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    public DailyIntake(LocalDate date, double calories, double protein, double fat, double carbohydrates) {
        this.date = date;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }
}
