package com.example.nutritioncalculator.food.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FoodDto {

    private String name;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;
}
