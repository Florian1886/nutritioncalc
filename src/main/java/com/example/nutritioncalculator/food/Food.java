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
    private int id;
    private String name;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

}
