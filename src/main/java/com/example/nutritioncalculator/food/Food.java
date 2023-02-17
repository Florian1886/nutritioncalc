package com.example.nutritioncalculator.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "food", schema = "nutritioncalc")
public class Food {

    @Id
    @GeneratedValue
    private int idF;
    private String name;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    public Food(String name, double calories, double protein, double fat, double carbohydrates) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }
}
